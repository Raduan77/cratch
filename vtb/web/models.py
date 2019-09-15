from django.db import models
from django.contrib.auth.models import User

# Create your models here.

class Friend(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)

    name = models.CharField(max_length=50)
    bank_account = models.CharField(max_length=25)

    def __str__(self):
        return f"{self.pk}.{self.name}"

class Group(models.Model):
    friends = models.ManyToManyField(Friend, related_name="groups", blank=True)

    name = models.CharField(max_length=50)
    description = models.TextField(max_length=100)
    background_id = models.IntegerField()

class Meeting(models.Model):
    group = models.ForeignKey(Group, related_name="meetings", on_delete=models.CASCADE)

    address = models.CharField(max_length=50)
    time = models.DateField()
    organizer = models.IntegerField()

    def is_open():
        food = self.receipt.food.all()
        unique = set()
        for item in food: 
            for friend in item.friends.all():
                unique.add(friend)
        return len(self.group.friends.all()) == len(unique)


class Receipt(models.Model):
    image = models.ImageField()

    meeting = models.OneToOneField(Meeting, on_delete=models.CASCADE, related_name="receipt", blank=True)

class Food(models.Model):
    receipt = models.ForeignKey(Receipt, on_delete=models.CASCADE, related_name="food")
    friends = models.ManyToManyField(Friend, related_name="food")

    name = models.CharField(max_length=50)
    price = models.FloatField()