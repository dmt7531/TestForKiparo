package data.repository.json

import com.squareup.moshi.Json

data class News(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "date") val date: String?,
    @Json(name = "keywords") val keywords: List<String>?,
    @Json(name = "visible") val visible: Boolean?
)

data class NewsList(val news: List<News>)

