from django.contrib.auth.models import User

from rest_framework import serializers
from . import models

class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ("username",)

class FriendSerializer(serializers.ModelSerializer):
    user = UserSerializer()
    class Meta:
        model = models.Friend
        fields = ("name", "user", "pk")

class GroupSerializer(serializers.ModelSerializer):
    friends = FriendSerializer(many=True)

    class Meta:
        model = models.Group
        fields = ("friends", "name", "description", "background_id", "pk")


class CreateGroupSerializer(serializers.ModelSerializer):
    friends = serializers.ListField()

    class Meta:
        model = models.Group
        fields = ("friends", "name", "description", "background_id")

class MeetingSerializer(serializers.ModelSerializer):
    class Meta:
        model = models.Meeting
        fields = ("address", "time", "organizer")

class ReceiptSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.Receipt
        fields = ("image",)