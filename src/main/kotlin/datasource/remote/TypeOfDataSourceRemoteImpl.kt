package datasource.remote

import data.datasource.TypeOfDataSource
import datasource.remote.apiservice.UrlType
import datasource.remote.apiservice.ApiService
import datasource.remote.apiservice.model.ApiServiceResponse

//    выбирает откуда скачать данные - какая ссылка
//    затем возвращает модель ApiServiceResponse для репозитория

class TypeOfDataSourceRemoteImpl : TypeOfDataSource {

    override fun downloadJsonData(): ApiServiceResponse {
        return ApiService.downloadFromUrl(urlType = UrlType.KIPARO_JSON)
    }

    override fun downloadXmlData(): ApiServiceResponse {
        return ApiService.downloadFromUrl(urlType = UrlType.KIPARO_XML)
    }
}