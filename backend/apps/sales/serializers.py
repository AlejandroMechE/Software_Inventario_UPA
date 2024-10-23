from rest_framework import serializers
from .models import Sale, DailySales

class SaleSerializer(serializers.ModelSerializer):

    class Meta:
        model = Sale
        fields = "__all__"
        
class DailySalesSerializer(serializers.ModelSerializer):

    class Meta:
        model = DailySales
        fields = "__all__"