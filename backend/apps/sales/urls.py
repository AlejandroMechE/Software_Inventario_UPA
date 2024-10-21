
from django.urls import path
from rest_framework import routers
from .views import DailySalesViewSet, SaleViewSet

router = routers.DefaultRouter()
router.register(r"Daily", DailySalesViewSet)
router.register(r"Sale", SaleViewSet)

urlpatterns = router.urls