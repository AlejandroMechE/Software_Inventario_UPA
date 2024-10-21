from rest_framework import serializers
from .models import Client, Disease

class ClientSerializer(serializers.ModelSerializer):

    class Meta:
        model = Client
        fields = '__all__'
        
class DiseaseSerializer(serializers.ModelSerializer):

    class Meta:
        model = Disease
        fields = "__all__"