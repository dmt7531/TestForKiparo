package data.storage.local.jsonstorage

import data.repository.json.News
import data.repository.json.NewsStorageJson
import domain.model.FindNewsByKeywordUseParams
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class NewsStorageJsonImpl : NewsStorageJson {

    private var newsList: List<News> = emptyList()

    override fun save(newsList: List<News>) {
        this.newsList = newsList
        println("Сохранили данные в StorageJson")
    }

    override fun displayAllNews() {
        val sortedNews =
            newsList.sortedBy { LocalDate.parse(it.date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z")) }

        sortedNews.forEach {
            val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy")
            val date = LocalDate.parse(it.date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z"))
            val formattedDate = formatter.format(date)
            val title = it.title ?: "Новость без заголовка"
            println("$formattedDate - $title.")
            println("${it.description}\n")
        }
    }

    override fun findNewsByKeyword(params: FindNewsByKeywordUseParams) {
        val keyword = params.params.lowercase()
        val news = newsList.filter { it.keywords?.contains(keyword) ?: false }
        if (news.isNotEmpty()) {
            news.forEach {
                val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy")
                val date = LocalDate.parse(it.date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z"))
                val formattedDate = formatter.format(date)
                val title = it.title ?: "Без заголовка"
                println("\n$formattedDate - $title.")
                println("${it.description}")
            }
        } else {
            println("\nНовости по запросу '$keyword' не найдены.")
        }
    }

}