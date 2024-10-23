from django.db import models
from apps.products.models import Product

# Create your models here.
class Sale(models.Model):
    productsId = models.ForeignKey(Product, on_delete=models.CASCADE)
    sale_date = models.DateField(verbose_name="date", auto_now=True, auto_now_add=False)
    cost = models.BigIntegerField(verbose_name="cost")

    class Meta:
        verbose_name = 'Sale'
        verbose_name_plural = 'Sales'

    def __str__(self):
        return self.sale_date

class DailySales(models.Model):
    date = models.DateField(verbose_name="date", auto_now=True, auto_now_add=False)
    cost = models.BigIntegerField(verbose_name="cost")

    class Meta:
        verbose_name = 'DailySales'
        verbose_name_plural = 'DailySaless'

    def __str__(self):
        pass
