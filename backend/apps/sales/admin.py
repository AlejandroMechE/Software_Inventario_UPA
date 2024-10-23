from django.contrib import admin
from .models import DailySales, Sale

# Register your models here.
admin.site.register(Sale)
admin.site.register(DailySales)