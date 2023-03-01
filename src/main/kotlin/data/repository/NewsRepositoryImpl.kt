package data.repository

import com.squareup.moshi.Moshi
import data.datasource.TypeOfDataSource
import data.storage.local.NewsFromJsonByMoshi
import domain.repository.NewsRepository

class NewsRepositoryImpl(private val dataSource: TypeOfDataSource) : NewsRepository {



    override fun downloadAndSaveJson() {
        println("Запрашиваем данные из DataSource")
        val responseFromDataSource = dataSource.downloadJsonData()
        println("Получили данные из DataSource")
//        println(responseFromDataSource.response)

        // затем маппит из ApiServiceResponse в коллекцию и сохраняет в Storage
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter(NewsFromJsonByMoshi::class.java)
        val newsList = jsonAdapter.fromJson(responseFromDataSource.response)
1
        println(newsList.toString())



        // затем маппит из ApiServiceResponse в коллекцию и сохраняет в Storage
        // ничего не возвращает
    }

    override fun downloadAndSaveXml() {
        val responseFromDataSource = dataSource.downloadXmlData()
    }

    override fun getAllNews() {
        TODO("Not yet implemented")
    }

    override fun findByKeyword() {
        TODO("Not yet implemented")
    }

}
