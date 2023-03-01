package data.storage.local

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class NewsFromJsonByMoshi(
    val name: String,
    val location: String,
    @Json(name = "news")
    val newsList: List<NewsList>,
)


data class NewsList(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val keywords: List<String>,
    val visible: Boolean,
)


////    @Json(name = "id")
//    val id: Int = 0,
////    @Json(name = "title")
//    val title: String = "",
////    @Json(name = "description")
//    val description: String = "",
////    @Json(name = "")
//    val date: String = "",
////    @Json(name = "keywords")
//    val keywords: List<String> = listOf(),
////    @Json(name = "visible")
//    val visible: Boolean = false,

//"name": "Super duper news",
//"location": "Minks",
//"news": [
//{
//    "id": 0,
//    "title": "Apple, IBM to bring iPads to 5 million Japanese seniors",
//    "description": "An initiative between Apple, IBM and Japan Post Holdings could put iPads in the hands of up to 5 million members of Japan's elderly population.",
//    "date": "2014-10-25 12:35:00 +0300",
//    "keywords": [
//    "apple",
//    "ibm"
//    ],
//    "visible": true
//},