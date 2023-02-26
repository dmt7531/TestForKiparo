import domain.UserInputOptions
import domain.usecase.DownloadJsonUseCase

fun main() {

    val userInput = UserInputOptions().startMenu()
    if (userInput == 1) {
        val downloadJson = DownloadJsonUseCase().execute()
        println(downloadJson.json)

    } else if (userInput == 2) {
        println("Скачиваем XML")
    }



}







//fun checkTransferDayLimit(transferTypeInput: Int): Long {
//    return when (transferTypeInput) {
//        1 -> checkCardTransferDayLimit()
//        2 -> checkVkPayTransferDayLimit()
//    }
//}