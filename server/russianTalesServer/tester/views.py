from django.shortcuts import render

from django.http import HttpResponse
from django.views.decorators.csrf import csrf_exempt

from django.utils.datastructures import MultiValueDictKeyError


@csrf_exempt
def repeat(request):
    try:
        if request.method == 'POST':
            return HttpResponse(request.POST['i'])
        return HttpResponse('no post')
    except MultiValueDictKeyError:
        return HttpResponse('error')
