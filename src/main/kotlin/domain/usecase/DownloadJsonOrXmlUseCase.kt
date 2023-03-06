package domain.usecase

import domain.model.DownloadJsonOrXmlParams
import domain.repository.NewsRepository

class DownloadJsonOrXmlUseCase(private val newsRepository: NewsRepository) {

    fun execute(params: DownloadJsonOrXmlParams) {
        if (params.inputParams == 1) {
            newsRepository.downloadAndSaveJson()
        } else {
            newsRepository.downloadAndSaveXml()
        }
    }
}