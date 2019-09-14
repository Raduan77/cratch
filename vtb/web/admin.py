from django.contrib import admin
from . import models
# Register your models here.

admin.site.register(models.Friend)
admin.site.register(models.Group)
admin.site.register(models.Meeting)
admin.site.register(models.Receipt)
admin.site.register(models.Food)