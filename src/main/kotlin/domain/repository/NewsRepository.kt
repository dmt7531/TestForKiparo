package domain.repository

interface NewsRepository {

    fun downloadAndSaveJson()

    fun downloadAndSaveXml()

    fun getAllNews()

    fun findByKeyword()

}