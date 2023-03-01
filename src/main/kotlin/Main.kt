import data.repository.NewsRepositoryImpl
import datasource.remote.TypeOfDataSourceRemoteImpl
import domain.model.DownloadJsonOrXmlParams
import domain.usecase.DownloadJsonOrXmlUseCase
import utils.UserInputOptions

fun main() {

    val dataSource = TypeOfDataSourceRemoteImpl()
    val newsRepository = NewsRepositoryImpl(dataSource = dataSource)
    val downloadJsonOrXmlUseCase = DownloadJsonOrXmlUseCase(newsRepository = newsRepository)
    val userInput = UserInputOptions().startMenu()

    downloadJsonOrXmlUseCase.execute(params = DownloadJsonOrXmlParams(inputParams = userInput))


}


//fun checkTransferDayLimit(transferTypeInput: Int): Long {
//    return when (transferTypeInput) {
//        1 -> checkCardTransferDayLimit()
//        2 -> checkVkPayTransferDayLimit()
//    }
//}