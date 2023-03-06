package domain.usecase

import domain.repository.NewsRepository

class DisplayAllNewsFromJsonUseCase(private val newsRepository: NewsRepository) {

    fun execute() {
        println("\nНовости, отсортированные по дате:\n")
        newsRepository.getAllNewsFromJson()
    }

}