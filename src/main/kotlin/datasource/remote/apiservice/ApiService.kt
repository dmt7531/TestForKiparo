package datasource.remote.apiservice

import datasource.remote.apiservice.model.ApiServiceResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

object ApiService {

    fun downloadFromUrl(urlType: UrlType): ApiServiceResponse {

        val client = OkHttpClient()
        var downloadedData = ""
        val request = Request.Builder()
            .url(urlType.url)
            .build()

        try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    throw IOException("Запрос к серверу не был успешен:" +
                            " ${response.code} ${response.message}")
                }
                downloadedData = response.body!!.string()
            }
        } catch (e: IOException) {
            println("Ошибка подключения: $e")
        }
        return ApiServiceResponse(response = downloadedData)
    }

}