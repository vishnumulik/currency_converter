package com.vishnu_mulik.currencyconverter.data.remote


import com.vishnu_mulik.currency_conversion.data.Resource
import com.vishnu_mulik.currencyconverter.data.error.NETWORK_ERROR
import com.vishnu_mulik.currencyconverter.data.error.UN_EXPECTED_RESPONSE
import com.vishnu_mulik.currencyconverter.data.models.CurrencyModel
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRatesModel
import com.vishnu_mulik.currencyconverter.data.remote.remoteService.RemoteDataCaller
import com.vishnu_mulik.currencyconverter.utils.NetworkConnectivity
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
class RemoteData
@Inject constructor(
    private val retrofit: Retrofit,
    private val networkConnectivity: NetworkConnectivity,
) : RemoteDataSource {


    private suspend fun <T> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String
    ): Resource<T> {
        return try {
            if (!networkConnectivity.isConnected()) {
                return Resource.DataError(errorCode = NETWORK_ERROR)
            }
            val result = request.invoke()
            if (result.isSuccessful) {
                return Resource.Success(data = result.body())
            } else {
                return Resource.DataError(errorCode = UN_EXPECTED_RESPONSE)
            }
        } catch (e: Throwable) {
            return Resource.DataError(errorCode = UN_EXPECTED_RESPONSE)
        }
    }

    override suspend fun fetchCurrencyList(): Resource<CurrencyModel> {
        val callerService = retrofit.create(RemoteDataCaller::class.java)
        return getResponse(
            request = { callerService.getCurrencyList() },
            defaultErrorMessage = "something went wrong , Please try again."
        )
    }

    override suspend fun fetchExchangeRates(): Resource<ExchangeRatesModel> {
        val callerService = retrofit.create(RemoteDataCaller::class.java)
        return getResponse(
            request = { callerService.getExchangeRates() },
            defaultErrorMessage = "something went wrong , Please try again."
        )
    }


}