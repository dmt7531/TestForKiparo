import data.repository.NewsRepositoryImpl
import data.storage.local.NewsStorageImpl
import datasource.remote.TypeOfDataSourceRemoteImpl
import domain.model.DownloadJsonOrXmlParams
import domain.model.FindNewsByKeywordUseParams
import domain.usecase.DisplayAllNewsUseCase
import domain.usecase.DownloadJsonOrXmlUseCase
import domain.usecase.FindNewsByKeywordUseCase
import utils.UserInputOptions

fun main() {

    val dataSource = TypeOfDataSourceRemoteImpl()
    val newsStorage = NewsStorageImpl()
    val newsRepository = NewsRepositoryImpl(dataSource = dataSource, newsStorage = newsStorage)
    val downloadJsonOrXmlUseCase = DownloadJsonOrXmlUseCase(newsRepository = newsRepository)
    val displayAllNewsUseCase = DisplayAllNewsUseCase(newsRepository = newsRepository)
    val firstUserInput = UserInputOptions().startMenu()
    val findNewsByKeywordUseCase = FindNewsByKeywordUseCase(newsRepository = newsRepository)

    downloadJsonOrXmlUseCase.execute(params = DownloadJsonOrXmlParams(inputParams = firstUserInput))

    val secondUserInput = UserInputOptions().secondMenu()
    if (secondUserInput == 1) {
        displayAllNewsUseCase.execute()
    } else {
        val userInputKeyword = UserInputOptions().checkUserInputKeyword()
        findNewsByKeywordUseCase.execute(params = FindNewsByKeywordUseParams(params = userInputKeyword))
    }

}