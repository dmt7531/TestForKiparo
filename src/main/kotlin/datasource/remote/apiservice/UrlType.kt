package datasource.remote.apiservice

enum class UrlType(val url: String) {
    KIPARO_JSON(url = "https://api2.kiparo.com/static/it_news.json"),
    KIPARO_XML(url = "https://api2.kiparo.com/static/it_news.xml");
}