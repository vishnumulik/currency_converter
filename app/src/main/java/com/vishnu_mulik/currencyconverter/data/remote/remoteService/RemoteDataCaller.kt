package com.vishnu_mulik.currencyconverter.data.remote.remoteService

import com.vishnu_mulik.currencyconverter.data.models.CurrencyModel
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRatesModel
import retrofit2.Response
import retrofit2.http.GET


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
interface RemoteDataCaller {

    @GET("/list")
    suspend fun getCurrencyList(): Response<CurrencyModel>

    @GET("/live")
    suspend fun getExchangeRates(): Response<ExchangeRatesModel>
}



