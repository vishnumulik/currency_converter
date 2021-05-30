package com.vishnu_mulik.currencyconverter.data.remote


import com.vishnu_mulik.currency_conversion.data.Resource
import com.vishnu_mulik.currencyconverter.BuildConfig
import com.vishnu_mulik.currencyconverter.data.error.DEFAULT_ERROR
import com.vishnu_mulik.currencyconverter.data.error.NETWORK_ERROR
import com.vishnu_mulik.currencyconverter.data.error.NO_INTERNET_CONNECTION
import com.vishnu_mulik.currencyconverter.data.error.UN_EXPECTED_RESPONSE
import com.vishnu_mulik.currencyconverter.data.models.CurrencyModel
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRatesModel
import com.vishnu_mulik.currencyconverter.utils.NetworkConnectivity
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
class RemoteData
@Inject constructor(
    private val serviceGenerator: ServiceGenerator,
    private val networkConnectivity: NetworkConnectivity,
) : RemoteDataSource {

    override suspend fun fetchCurrencyList(): Resource<CurrencyModel> {
        if (!networkConnectivity.isConnected()) {
            return Resource.Error(errorCode = -1)
        }
        try {
            val response = serviceGenerator.apiService.getCurrencyList(BuildConfig.ACCESS_KEY)
            val responseCode = response.code()
            if (response.isSuccessful) {
                when (response.body()) {
                    is CurrencyModel -> {
                        return Resource.Success(data = response.body())
                    }
                    else -> {
                        return Resource.Error(errorCode = UN_EXPECTED_RESPONSE)
                    }
                }
            } else {
                return Resource.Error(responseCode)
            }
        } catch (e: IOException) {
            return Resource.Error(errorCode = DEFAULT_ERROR)
        }
    }

    override suspend fun fetchExchangeRates(): Resource<ExchangeRatesModel> {
        if (!networkConnectivity.isConnected()) {
            return Resource.Error(errorCode = -1)
        }
        try {
            val response = serviceGenerator.apiService.getExchangeRates(BuildConfig.ACCESS_KEY)
            val responseCode = response.code()
            if (response.isSuccessful) {
                when (response.body()) {
                    is ExchangeRatesModel -> {
                        return Resource.Success(data = response.body())
                    }
                    else -> {
                        return Resource.Error(errorCode = UN_EXPECTED_RESPONSE)
                    }
                }
            } else {
                return Resource.Error(responseCode)
            }
        } catch (e: IOException) {
            return Resource.Error(errorCode = DEFAULT_ERROR)
        }
    }


}