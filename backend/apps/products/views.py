from rest_framework import viewsets
from .models import Product
from .serializers import ProductSerializer, ProductNameSerializer 


# Create your views here.
class ProductViewSet(viewsets.ModelViewSet):
    queryset = Product.objects.all()
    serializer_class = ProductSerializer

class ProductListViewSet(viewsets.ModelViewSet):
    queryset = Product.objects.all()
    serializer_class = ProductNameSerializer

