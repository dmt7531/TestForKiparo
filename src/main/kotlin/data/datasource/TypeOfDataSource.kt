package data.datasource

import datasource.remote.apiservice.model.ApiServiceResponse

interface TypeOfDataSource {
    fun downloadJsonData(): ApiServiceResponse
    fun downloadXmlData(): ApiServiceResponse
}