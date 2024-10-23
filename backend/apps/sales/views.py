from rest_framework import viewsets
from .models import Sale, DailySales
from .serializers import SaleSerializer, DailySalesSerializer

# Create your views here.
class SaleViewSet(viewsets.ModelViewSet):
    queryset = Sale.objects.all()
    serializer_class = SaleSerializer

class DailySalesViewSet(viewsets.ModelViewSet):
    queryset = DailySales.objects.all()
    serializer_class = DailySalesSerializer