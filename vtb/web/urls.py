from django.urls import path
from django.views.generic import RedirectView

from rest_framework.authtoken import views as auth_views

from . import views

api_urls = []

urlpatterns = api_urls