package data.repository

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import data.datasource.TypeOfDataSource
import data.repository.json.News
import data.repository.json.NewsList
import data.repository.json.NewsStorageJson
import data.repository.xml.NewsStorageXml
import data.repository.xml.NewsXml
import data.repository.xml.RootXml
import domain.model.FindNewsByKeywordUseParams
import domain.repository.NewsRepository
import org.simpleframework.xml.core.Persister

class NewsRepositoryImpl(
    private val dataSource: TypeOfDataSource,
    private val newsStorageJson: NewsStorageJson,
    private val newsStorageXml: NewsStorageXml,
) :
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
        if (news != null) newsStorageJson.save(newsList = news)
    }

    override fun getAllNewsFromJson() {
        newsStorageJson.displayAllNews()
    }

    override fun findNewsByKeywordFromJson(params: FindNewsByKeywordUseParams) {
        newsStorageJson.findNewsByKeyword(params)
    }

    override fun downloadAndSaveXml() {
        println("Запрашиваем данные из DataSource")
        val responseFromDataSource = dataSource.downloadXmlData()
        val xml = responseFromDataSource.response
        println("Получили данные из DataSource")
        val serializer = Persister()
        val rootXml = serializer.read(RootXml::class.java, xml)

        val newsList = rootXml.news?.news?.map { elementXml ->
            NewsXml(
                elementXml.id,
                elementXml.title,
                elementXml.date,
                elementXml.description,
                elementXml.keywords?.keywords,
                elementXml.visible
            )
        } ?: emptyList()
        println("Распарсили данные с помощью Simple XML")

        newsStorageXml.save(newsList)
    }

    override fun getAllNewsFromXml() {
        newsStorageXml.displayAllNews()
    }

    override fun findNewsByKeywordFromXml(params: FindNewsByKeywordUseParams) {
        newsStorageXml.findNewsByKeyword(params)
    }

}