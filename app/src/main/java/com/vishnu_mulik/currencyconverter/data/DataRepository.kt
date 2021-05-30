package com.vishnu_mulik.currencyconverter.data

import com.vishnu_mulik.currency_conversion.data.Resource
import com.vishnu_mulik.currencyconverter.data.localData.SharedPrefrenceData
import com.vishnu_mulik.currencyconverter.data.models.CurrencyModel
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRatesModel
import com.vishnu_mulik.currencyconverter.data.remote.RemoteData
import com.vishnu_mulik.currencyconverter.utils.DateTimeUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
class DataRepository  @Inject constructor(
    private val remoteRepository: RemoteData,
    private val localRepository: SharedPrefrenceData,
    private val ioDispatcher: CoroutineContext
): DataRepositorySource {

    override suspend fun getCurrencyList(): Flow<Resource<CurrencyModel>> {
        return flow {
            val lastUpdatedValue = localRepository.getLastUpdatedDate().data
            lastUpdatedValue?.let {
                if(it>0){
                    //TODO check date time from value room data base and call remote repository based on that
                    ///update from room database
                    emit(remoteRepository.fetchCurrencyList())
                }else{
                    localRepository.saveLastUpdatedDate(DateTimeUtils.getCurrentTimestamp())
                    emit(remoteRepository.fetchCurrencyList())
                }
            }}.flowOn(ioDispatcher)
    }

    override suspend fun getExchangeRates(): Flow<Resource<ExchangeRatesModel>> {
        return flow {
            emit(remoteRepository.fetchExchangeRates())
        }.flowOn(ioDispatcher)
    }
}