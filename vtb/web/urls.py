from django.urls import path
from django.views.generic import RedirectView

from rest_framework.authtoken import views as auth_views

from . import views

api_urls = [
    path("api/v1/token", auth_views.obtain_auth_token, name="api-token-auth"),
    path("api/v1/group/list", views.GroupList.as_view(), name="group-list"),
    path("api/v1/group/create", views.CreateGroupAPIView.as_view(), name="group-create"),
    path("api/v1/group/<int:pk>/meeting-create", views.CreateMeetingAPIVIew.as_view(), name="meeting-create"),
    path("api/v1/group/<int:pk>/meeting-list", views.MeetingListAPIView.as_view(), name="meeting-list"),
    path("api/v1/meeting/<int:pk>/add-receipt", views.CreateReceiptAPIVIew.as_view(), name="meeting-list"),\
    path("api/v1/user-info", views.GetUserInfoAPIView.as_view(), name="user-info"),
    path("api/v1/food/<int:pk>/add", views.AddFoodAPIView.as_view(), name="add-food")
]

urlpatterns = api_urls