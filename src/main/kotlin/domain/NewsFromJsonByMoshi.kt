package domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsFromJsonByMoshi(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "date")
    val date: String,
    @Json(name = "keywords")
    val keywords: List<String>,
    @Json(name = "visible")
    val visible: Boolean,
)