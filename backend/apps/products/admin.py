from django.contrib import admin
from .models import Product, AdjustInventory, Category, Provider

# Register your models here.
admin.site.register(Product)
admin.site.register(Category)
admin.site.register(Provider)
admin.site.register(AdjustInventory)