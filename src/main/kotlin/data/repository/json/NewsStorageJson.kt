package data.repository.json

import domain.model.FindNewsByKeywordUseParams

interface NewsStorageJson {

    fun save(newsList: List<News>)

    fun displayAllNews()

    fun findNewsByKeyword(params: FindNewsByKeywordUseParams)

}