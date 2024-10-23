from django.db import models

# Create your models here.
class Category(models.Model):
    name = models.CharField(verbose_name="name category", max_length=50)

    class Meta:
        verbose_name = 'Categoría'
        verbose_name_plural = 'Categorías'

    def __str__(self):
        return self.name
    
class Provider(models.Model):
    name = models.CharField(verbose_name="name", max_length=50)
    contact_name = models.CharField(verbose_name="contact name", max_length=50)
    phone = models.BigIntegerField(verbose_name="phone")
    email = models.EmailField(verbose_name="email", max_length=254)
    address = models.CharField(verbose_name="address", max_length=50)
    
    class Meta:
        verbose_name = 'Provedor'
        verbose_name_plural = 'Provedores'

    def __str__(self):
        return f"{self.name} | {self.contact_name}"

class Product(models.Model):
    bar_code = models.BigIntegerField(verbose_name="bar code")
    name = models.CharField(verbose_name="name product", max_length=100)
    brand = models.CharField(verbose_name='brand', max_length=100)
    expiration_date = models.DateField(verbose_name='expiration date', auto_now=False, auto_now_add=False)
    description = models.TextField(verbose_name='description')
    min_stock = models.IntegerField(verbose_name='min stock')
    stock = models.IntegerField(verbose_name='stock')
    provider = models.CharField(verbose_name='provider', max_length=100)
    location = models.CharField(verbose_name='location', max_length=50)
    percents = models.IntegerField(verbose_name="percents", null=True)
    category = models.OneToOneField(Category, on_delete=models.CASCADE, null=True)
    restock_date = models.DateField(verbose_name="restock date", auto_now=False, auto_now_add=False, null=True)

    class Meta:
        verbose_name = 'Producto'
        verbose_name_plural = 'Productos'

    def __str__(self):
        return self.name
    
class AdjustInventory(models.Model):
    date_adjust = models.DateField(verbose_name="adjust", auto_now=False, auto_now_add=True)
    type_adjust = models.CharField(verbose_name="type adjust", max_length=50)
    cuantity = models.IntegerField(verbose_name="cuantity")
    reason = models.TextField(verbose_name="reason")

    class Meta:
        verbose_name = 'Ajuste de inventario'
        verbose_name_plural = 'Ajustes de inventario'

    def __str__(self):
        return self.date_adjust

