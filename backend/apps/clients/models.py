from django.db import models
from apps.products.models import Product

# Create your models here.
class Disease(models.Model):
    # TODO: Define fields here
    name = models.CharField(verbose_name='name', max_length=50)

    class Meta:
        verbose_name = 'Disease'
        verbose_name_plural = 'Disease'

    def __str__(self):
        return self.name


class Client(models.Model):
    # TODO: Define fields here
    name = models.CharField(verbose_name='name client', max_length=100)
    phone = models.BigIntegerField(verbose_name='phone number')
    diseases = models.ForeignKey(Disease, on_delete=models.CASCADE)
    medicines = models.ForeignKey(Product, on_delete=models.CASCADE)
    birthdate = models.DateField(verbose_name='birthdate', auto_now=False, auto_now_add=False)
    email = models.EmailField(verbose_name="email", max_length=254, null=True)
    suscription = models.TextField(verbose_name="suscription", null=True)
    address = models.CharField(verbose_name="address", max_length=100, blank=True)

    class Meta:
        verbose_name = 'Client'
        verbose_name_plural = 'Clients'

    def __str__(self):
        return self.name
