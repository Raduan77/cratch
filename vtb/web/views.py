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