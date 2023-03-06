import data.repository.NewsRepositoryImpl
import data.storage.local.jsonstorage.NewsStorageJsonImpl
import data.storage.local.xmlstorage.NewsStorageXmlImpl
import datasource.remote.TypeOfDataSourceRemoteImpl
import domain.model.DownloadJsonOrXmlParams
import domain.model.FindNewsByKeywordUseParams
import domain.usecase.*
import utils.UserInputOptions

fun main() {

    val dataSource = TypeOfDataSourceRemoteImpl()
    val newsStorageJson = NewsStorageJsonImpl()
    val newsStorageXml = NewsStorageXmlImpl()
    val newsRepository =
        NewsRepositoryImpl(dataSource = dataSource, newsStorageJson = newsStorageJson, newsStorageXml = newsStorageXml)

    val downloadJsonOrXmlUseCase = DownloadJsonOrXmlUseCase(newsRepository = newsRepository)
    val displayAllNewsFromJsonUseCase = DisplayAllNewsFromJsonUseCase(newsRepository = newsRepository)
    val findNewsByKeywordFromJsonUseCase = FindNewsByKeywordFromJsonUseCase(newsRepository = newsRepository)
    val displayAllNewsFromXmlUseCase = DisplayAllNewsFromXmlUseCase(newsRepository = newsRepository)
    val findNewsByKeywordFromXmlUseCase = FindNewsByKeywordFromXmlUseCase(newsRepository = newsRepository)

    val firstMenuUserInput = UserInputOptions().firstMenu()
    downloadJsonOrXmlUseCase.execute(params = DownloadJsonOrXmlParams(inputParams = firstMenuUserInput))

    val secondMenuUserInput = UserInputOptions().secondMenu()

    if (firstMenuUserInput == 1) {
        if (secondMenuUserInput == 1) {
            displayAllNewsFromJsonUseCase.execute()
        } else {
            val userInputKeyword = UserInputOptions().checkUserInputKeyword()
            findNewsByKeywordFromJsonUseCase.execute(params = FindNewsByKeywordUseParams(params = userInputKeyword))
        }
    } else {
        if (secondMenuUserInput == 1) {
            displayAllNewsFromXmlUseCase.execute()
        } else {
            val userInputKeyword = UserInputOptions().checkUserInputKeyword()
            findNewsByKeywordFromXmlUseCase.execute(params = FindNewsByKeywordUseParams(params = userInputKeyword))
        }
    }

}