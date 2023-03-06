package domain.usecase

import domain.model.FindNewsByKeywordUseParams
import domain.repository.NewsRepository

class FindNewsByKeywordFromJsonUseCase(private val newsRepository: NewsRepository) {

    fun execute(params: FindNewsByKeywordUseParams) {
        newsRepository.findNewsByKeywordFromJson(params)
    }

}