from rest_framework import viewsets
from django.contrib.auth.models import User
from .serializers import AuthSerializer

# Create your views here.
class AuthViewSet(viewsets.ModelViewSet):
    queryset = User.objects.all()
    serializer_class = AuthSerializer