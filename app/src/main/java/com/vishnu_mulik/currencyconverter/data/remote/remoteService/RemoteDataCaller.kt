package com.vishnu_mulik.currencyconverter.data.remote.remoteService

import com.vishnu_mulik.currencyconverter.data.models.CurrencyModel
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRatesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
interface RemoteDataCaller {

    @GET("list")
   suspend fun getCurrencyList(@Query("access_key") id: String?): Response<CurrencyModel>

    @GET("live")
    suspend fun getExchangeRates(@Query("access_key") id: String?): Response<ExchangeRatesModel>
}