package data.storage.local

import domain.model.FindNewsByKeywordUseParams

interface NewsStorage {

    fun save(newsList: List<News>)

    fun displayAllNews()

    fun findNewsByKeyword(params: FindNewsByKeywordUseParams)

}