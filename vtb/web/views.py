from django.shortcuts import render

# Create your views here.

from django.shortcuts import render, get_object_or_404
import json
import operator
import random

from rest_framework import status
from rest_framework.generics import CreateAPIView, ListAPIView
from rest_framework.permissions import AllowAny
from rest_framework.response import Response
from rest_framework.views import APIView

from . import models, serializers


from utils.parse_ticket import get_goods_from_ticket


class GetUserInfoAPIView(APIView):

    def get(self, request):
        username = request.data.get('username')
        user = get_object_or_404(models.User, username=username)
        return Response({"username": user.username, "pk": user.pk}, status=status.HTTP_200_OK)

class GetAllUsersAPIView(ListAPIView):
    serializer_class = serializers.FriendSerializer

    def get_queryset(self):
        return models.Friend.objects.all()

class GroupList(ListAPIView):
    serializer_class = serializers.GroupSerializer

    def get_queryset(self):
        print(self.request.user)
        friend = models.Friend.objects.get(user=self.request.user)
        return friend.groups

class CreateGroupAPIView(CreateAPIView):
    serializer_class = serializers.CreateGroupSerializer

    def create(self, request):
        serializer = self.get_serializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        name = serializer.validated_data["name"]
        description = serializer.validated_data["description"]
        background_id = serializer.validated_data["background_id"]
        friends = [
            get_object_or_404(models.Friend, pk=pk)
            for pk in serializer.validated_data["friends"]
        ]
        group = models.Group.objects.create(name=name, description=description, background_id=background_id)
        for friend in friends:
            friend.groups.add(group)
            friend.save()
        group.save()
        return Response({}, status=status.HTTP_201_CREATED)
        
class CreateMeetingAPIVIew(CreateAPIView):
    serializer_class = serializers.MeetingSerializer

    def create(self, request, pk):
        serializer = self.get_serializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        group = get_object_or_404(models.Group, pk=pk)
        address = serializer.validated_data['address']
        time = serializer.validated_data['time']
        organizer = serializer.validated_data['organizer']
        meeting = models.Meeting.objects.create(group=group, address=address, time=time, organizer=organizer)
        return Response({}, status=status.HTTP_201_CREATED)

class MeetingListAPIView(ListAPIView):
    serializer_class = serializers.MeetingSerializer

    def get_queryset(self, *args, **kwargs):
        group = get_object_or_404(models.Group, pk=self.kwargs['pk'])
        return group.meetings


class CreateReceiptAPIVIew(CreateAPIView):
    serializer_class = serializers.ReceiptSerializer

    def create(self, request, pk):
        serializer = self.get_serializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        meeting = get_object_or_404(models.Meeting, pk=pk)
        receipt = models.Receipt.objects.create(meeting=meeting, image=serializer.validated_data['image'])

        goods = get_goods_from_ticket(receipt.image.path)

        food = []
        for name, price in goods:
            print(name, price)
            food.append(models.Food.objects.create(name=name, receipt=receipt, price=price))
        return Response(
            {
                "foods":[
            {
                "name": item.name, "pk": item.pk, "price":item.price
            } for item in food
            ]
        }, status=status.HTTP_201_CREATED
        )

class AddFoodAPIView(APIView):
    def post(self, request, pk):
        food = get_object_or_404(models.Food, pk=pk)
        friend = get_object_or_404(models.Friend, user=self.request.user)
        food.friends.add(friend)
        return Response({}, status=status.HTTP_202_ACCEPTED)

class GetSplittedPriceAPIView(APIView):
    def get(self, request, pk):
        friend = get_object_or_404(models.Friend, user=self.request.user)
        meeting = get_object_or_404(models.Meeting, pk=pk)
        receipt = meeting.receipt
        dct = {}
        for food in receipt.food.all():
            friends = food.friends.all()
            n = len(friends)
            splitted_price = food.price / n
            for friend in friends:
                if friend not in dct:
                    dct[friend] = 0
                dct[friend] += splitted_price
        return Response({"split_price":dct[friend]}, status=status.HTTP_200_OK)

