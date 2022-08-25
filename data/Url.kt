package com.supmegcompany.russian_tales.network

import java.net.URL

class Url(_url:String) {
    private var parametersName: MutableList<String> = mutableListOf()
    private var parametersValue: MutableList<String> = mutableListOf()

    private var url: String = _url

    fun addParameter(name: String, value: String){
        parametersName.add(name)
        parametersValue.add(value)
    }

    public fun addParameter(name: List<String>, value: List<String>){
        for(i in name.indices){
            parametersName.add(name[i])
            parametersValue.add(value[i])
        }
    }

    fun getUrl(): String{
        return url
    }

    fun getParametersName(): MutableList<String> {
        return parametersName
    }

    fun getParametersValue(): MutableList<String> {
        return parametersValue
    }
}