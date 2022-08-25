package com.supmegcompany.russian_tales.network

import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class Request{
    companion object {
        fun madeRequest(url: Url): String {
            val httpsConnection = URL(url.toString()).openConnection() as HttpsURLConnection

            httpsConnection.apply {
                connectTimeout = 1000
                requestMethod = "POST"
                doInput = true
            }

            var parametersName: MutableList<String> = url.getParametersName()
            var parametersValue: MutableList<String> = url.getParametersValue()

            for (i in 0..parametersName.size){
                httpsConnection.addRequestProperty(parametersName[i], parametersName[i])
            }

            if(httpsConnection.responseCode != HttpsURLConnection.HTTP_OK){
                throw Exception("Server error " + httpsConnection.responseCode)
            }

            httpsConnection.disconnect()

            val streamReader = InputStreamReader(httpsConnection.inputStream)
            var data: String
            streamReader.use{
                data = it.readText()
            }
            if (data.contains("$\$ERROR$$")){
                throw Exception("Server error: $data")
            }
            return data
        }
    }
}