package data.repository

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import data.datasource.TypeOfDataSource
import data.storage.local.News
import data.storage.local.NewsList
import data.storage.local.NewsStorage
import domain.model.FindNewsByKeywordUseParams
import domain.repository.NewsRepository

class NewsRepositoryImpl(private val dataSource: TypeOfDataSource, private val newsStorage: NewsStorage) :
    NewsRepository {


    override fun downloadAndSaveJson() {
        println("Запрашиваем данные из DataSource")
        val responseFromDataSource = dataSource.downloadJsonData()
        val json = responseFromDataSource.response
        println("Получили данные из DataSource")

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter = moshi.adapter(NewsList::class.java)
        val newsList = adapter.fromJson(json)
        println("Распарсили данные с помощью Moshi")

        val news: List<News>? = newsList?.news
        if (news != null) {
            newsStorage.save(news)
        }
    }

    override fun downloadAndSaveXml() {
        val responseFromDataSource = dataSource.downloadXmlData()
    }

    override fun getAllNews() {
        newsStorage.displayAllNews()
    }

    override fun findNewsByKeyword(params: FindNewsByKeywordUseParams) {
        newsStorage.findNewsByKeyword(params)
    }


}