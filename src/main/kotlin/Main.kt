import data.repository.NewsRepositoryImpl
import data.storage.local.jsonstorage.NewsStorageJsonImpl
import data.storage.local.xmlstorage.NewsStorageXmlImpl
import datasource.remote.TypeOfDataSourceRemoteImpl
import domain.model.DownloadJsonOrXmlParams
import domain.model.FindNewsByKeywordUseParams
import domain.usecase.*
import utils.UserInputOptions

fun main() {

    val firstMenuUserInput = UserInputOptions().firstMenu()

    val dataSource = TypeOfDataSourceRemoteImpl()
    val newsStorageJson = NewsStorageJsonImpl()
    val newsStorageXml = NewsStorageXmlImpl()
    val newsRepository =
        NewsRepositoryImpl(dataSource = dataSource, newsStorageJson = newsStorageJson, newsStorageXml = newsStorageXml)

    val downloadJsonOrXmlUseCase = DownloadJsonOrXmlUseCase(newsRepository = newsRepository)
    downloadJsonOrXmlUseCase.execute(params = DownloadJsonOrXmlParams(inputParams = firstMenuUserInput))

    val secondMenuUserInput = UserInputOptions().secondMenu()

    if (firstMenuUserInput == 1) {
        if (secondMenuUserInput == 1) {
            val displayAllNewsFromJsonUseCase = DisplayAllNewsFromJsonUseCase(newsRepository = newsRepository)
            displayAllNewsFromJsonUseCase.execute()
        } else {
            val findNewsByKeywordFromJsonUseCase = FindNewsByKeywordFromJsonUseCase(newsRepository = newsRepository)
            val userInputKeyword = UserInputOptions().checkUserInputKeyword()
            findNewsByKeywordFromJsonUseCase.execute(params = FindNewsByKeywordUseParams(params = userInputKeyword))
        }
    } else {
        if (secondMenuUserInput == 1) {
            val displayAllNewsFromXmlUseCase = DisplayAllNewsFromXmlUseCase(newsRepository = newsRepository)
            displayAllNewsFromXmlUseCase.execute()
        } else {
            val findNewsByKeywordFromXmlUseCase = FindNewsByKeywordFromXmlUseCase(newsRepository = newsRepository)
            val userInputKeyword = UserInputOptions().checkUserInputKeyword()
            findNewsByKeywordFromXmlUseCase.execute(params = FindNewsByKeywordUseParams(params = userInputKeyword))
        }
    }

}