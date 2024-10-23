
from django.urls import path
from rest_framework import routers
from .views import ClientViewSet, DiseaseViewSet

router = routers.DefaultRouter()
router.register(r"Client", ClientViewSet)
router.register(r"Disease", DiseaseViewSet)

urlpatterns = router.urls