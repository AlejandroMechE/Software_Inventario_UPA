
from django.urls import path
from rest_framework import routers
from .views import ProductViewSet, ProductListViewSet

router = routers.DefaultRouter()
router.register(r"Product", ProductViewSet, basename="products")
router.register(r"ProductList", ProductListViewSet, basename="product_list")
urlpatterns = router.urls

