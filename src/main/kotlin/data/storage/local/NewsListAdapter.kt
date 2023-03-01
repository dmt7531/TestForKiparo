package data.storage.local

import com.squareup.moshi.FromJson
import com.squareup.moshi.Json

object NewsListAdapter {
    @FromJson
    fun fromJson(newsList: NewsFromJsonByMoshi): NewsList {
        return NewsList(newsList.newsList)


    }
}
//data class NewsFromJsonByMoshi(
//    val name: String,
//    val location: String,
//    @Json(name = "news")
//    val newsList: List<NewsList>,
//)
//
//
//data class NewsList(
//    val id: Int,
//    val title: String,
//    val description: String,
//    val date: String,
//    val keywords: List<String>,
//    val visible: Boolean,
//)
