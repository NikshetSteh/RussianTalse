from django.db import models


class Tales(models.Model):
    name = models.TextField("название")
    plot = models.TextField("сюжет")
    characters = models.TextField("персоонажи")
    historyCreation = models.TextField("история создание")
    author = models.TextField("автор")
    text = models.TextField("текст")


class Illustration(models.Model):
    taleId = models.IntegerField("id сказки")
    image = models.ImageField("картинка")
