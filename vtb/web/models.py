from django.db import models
from django.contrib.auth.models import User

# Create your models here.

class Friend(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)

    name = models.CharField(max_length=50)
    tag = models.CharField(max_length=50)
    bank_account = models.CharField(max_length=25)

class Group(models.Model):
    friends = models.ManyToManyField(Friend, related_name="groups")

    name = models.CharField(max_length=50)
    uuid = models.CharField(max_length=8)
    description = models.TextField(max_length=100)
    background_id = models.IntegerField()

class Meeting(models.Model):
    group = models.ForeignKey(Group, related_name="meetings", on_delete=models.CASCADE)

    address = models.CharField(max_length=50)
    time = models.DateField()
    organizer = models.IntegerField()

class Receipt(models.Model):
    image = models.ImageField()

class Food(models.Model):
    receipt = models.ForeignKey(Receipt, on_delete=models.CASCADE, related_name="food")
    friends = models.ManyToManyField(Friend, related_name="food")

    name = models.CharField(max_length=50)
    price = models.FloatField()
