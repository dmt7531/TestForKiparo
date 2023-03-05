package domain.usecase

import domain.model.FindNewsByKeywordUseParams
import domain.repository.NewsRepository

class FindNewsByKeywordUseCase(private val newsRepository: NewsRepository) {

    fun execute(params: FindNewsByKeywordUseParams) {
        newsRepository.findNewsByKeyword(params)
    }
}