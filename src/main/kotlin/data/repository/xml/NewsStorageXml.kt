package data.repository.xml

import domain.model.FindNewsByKeywordUseParams

interface NewsStorageXml {

    fun save(newsList: List<NewsXml>)

    fun displayAllNews()

    fun findNewsByKeyword(params: FindNewsByKeywordUseParams)

}