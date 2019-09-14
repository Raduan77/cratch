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
    serializer_class = serializers.GroupSerializer

    def create(self, request):
        serializer = self.get_serializer(data=request.data)
        print(123)
        serializer.is_valid(raise_exception=True)
        name = serializer.validated_data["name"]
        description = serializer.validated_data["description"]
        background_id = serializer.validated_data["background_id"]
        friends = [
            get_object_or_404(models.Friend, pk=friend_object["pk"])
            for friend_object in serializer.validated_data["friends"]
        ]
        group = models.Group.objects.create(name=name, description=description, background_id=background_id)
        for friend in friends:
            friend.groups.add(group)
            friend.save()
        group.save()
        return Response({}, status=status.HTTP_201_CREATED)
        

        