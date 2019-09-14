from django.urls import path
from django.views.generic import RedirectView

from rest_framework.authtoken import views as auth_views

from . import views

api_urls = [
    path("api/v1/token", auth_views.obtain_auth_token, name="api-token-auth"),
    path("api/v1/group/list", views.GroupList.as_view(), name="group-list"),
    path("api/v1/group/create", views.CreateGroupAPIView.as_view(), name="group-create"),
]

urlpatterns = api_urls