from django.db import models
from apps.products.models import Product

# Create your models here.
class Sale(models.Model):
    productsId = models.ForeignKey(Product, on_delete=models.CASCADE)
    sale_date = models.DateField(verbose_name="date", auto_now=True, auto_now_add=False)
    cost = models.BigIntegerField(verbose_name="cost")

    class Meta:
        verbose_name = 'Venta'
        verbose_name_plural = 'Ventas'

    def __str__(self):
        return self.sale_date

class DailySales(models.Model):
    date = models.DateField(verbose_name="date", auto_now=True, auto_now_add=False)
    cost = models.BigIntegerField(verbose_name="cost")

    class Meta:
        verbose_name = 'Venta del día'
        verbose_name_plural = 'Ventas del día'

    def __str__(self):
        pass
