package domain.repository

import domain.model.FindNewsByKeywordUseParams

interface NewsRepository {

    fun downloadAndSaveJson()

    fun downloadAndSaveXml()

    fun getAllNews()

    fun findNewsByKeyword(params: FindNewsByKeywordUseParams)

}