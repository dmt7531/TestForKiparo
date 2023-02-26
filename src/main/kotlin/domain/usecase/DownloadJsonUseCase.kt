package domain.usecase

import domain.model.DownloadJson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class DownloadJsonUseCase {

    fun execute(): DownloadJson {

        val client = OkHttpClient()
        val downloadJson = DownloadJson("")
        val request = Request.Builder()
            .url("https://api2.kiparo.com/static/it_news.json")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    throw IOException("Запрос к серверу не был успешен:" +
                            " ${response.code} ${response.message}")
                }
                // вывод тела ответа
                downloadJson.json = response.body!!.string()
            }
        } catch (e: IOException) {
            println("Ошибка подключения: $e");
        }
        return downloadJson
    }

}

//1. Скачиваем с помощью HTTPUrlConnector, OkHttp
//2. Всю информацию из файла парсим через Moshi и закидываем в коллекцию
//3. Пользователю предлагается несколько функций, которые приложение должно делать


//println("Имя кота: ${murzik?.name}")
// I/System.out: Cat(name=Мурзик, age=9, color=-16777216)
// I/System.out: Имя кота: Мурзик

