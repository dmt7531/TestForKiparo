package domain.repository

import domain.model.FindNewsByKeywordUseParams

interface NewsRepository {

    fun downloadAndSaveJson()

    fun getAllNewsFromJson()

    fun findNewsByKeywordFromJson(params: FindNewsByKeywordUseParams)

    fun downloadAndSaveXml()

    fun getAllNewsFromXml()

    fun findNewsByKeywordFromXml(params: FindNewsByKeywordUseParams)

}