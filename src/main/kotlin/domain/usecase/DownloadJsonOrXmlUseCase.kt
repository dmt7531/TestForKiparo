package domain.usecase

import domain.model.DownloadJsonOrXmlParams
import domain.repository.NewsRepository

class DownloadJsonOrXmlUseCase(private val newsRepository: NewsRepository) {

    fun execute(params: DownloadJsonOrXmlParams) {

        return if (params.inputParams == 1) {
            println("Скачиваем JSON...")
            newsRepository.downloadAndSaveJson()

        } else {
            println("Скачиваем XML...")
            newsRepository.downloadAndSaveXml()
        }

    }
}

//1. Скачиваем с помощью HTTPUrlConnector, OkHttp
//2. Всю информацию из файла парсим через Moshi и закидываем в коллекцию
//3. Пользователю предлагается несколько функций, которые приложение должно делать


//println("Имя кота: ${murzik?.name}")
// I/System.out: Cat(name=Мурзик, age=9, color=-16777216)
// I/System.out: Имя кота: Мурзик

//class SaveCalcPriceUseCase(private val calcPriceRepository: CalcPriceRepository) {
//    fun execute(params: SaveCalcPriceParams): SaveCalcPrice {
//        val saveCalcPrice = SaveCalcPrice(price = params.price, weightGramsOrMl = params.weightGramsOrMl, pricePerKgOrLiter = 1000 / params.weightGramsOrMl * params.price)
//        calcPriceRepository.save(saveCalcPrice)
//        return saveCalcPrice
//    }
//}

