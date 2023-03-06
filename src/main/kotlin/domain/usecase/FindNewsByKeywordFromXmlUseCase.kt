package domain.usecase

import domain.model.FindNewsByKeywordUseParams
import domain.repository.NewsRepository

class FindNewsByKeywordFromXmlUseCase(private val newsRepository: NewsRepository) {

    fun execute(params: FindNewsByKeywordUseParams) {
        newsRepository.findNewsByKeywordFromXml(params)
    }

}