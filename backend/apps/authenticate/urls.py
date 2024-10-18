
from django.urls import path
from rest_framework import routers
from .views import AuthViewSet

router = routers.DefaultRouter()
router.register(r"Auth", AuthViewSet)

urlpatterns = router.urls