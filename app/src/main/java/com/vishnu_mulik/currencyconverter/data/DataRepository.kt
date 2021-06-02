package com.vishnu_mulik.currencyconverter.data

import com.vishnu_mulik.currency_conversion.data.Resource
import com.vishnu_mulik.currencyconverter.data.localData.SharedPrefrenceData
import com.vishnu_mulik.currencyconverter.data.localData.room.RoomData
import com.vishnu_mulik.currencyconverter.data.models.Currency
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRates
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
class DataRepository @Inject constructor(
    private val remoteRepository: RemoteData,
    private val localRepository: SharedPrefrenceData,
    private val roomData: RoomData,
    private val ioDispatcher: CoroutineContext
) : DataRepositorySource {



    override suspend fun getCurrencyList(): Flow<Resource<out Any>> {
        return flow {
            val lastUpdatedValue = localRepository.getLastUpdatedDate(SHARED_CURRENCY_LAST_UPDATED).data
            lastUpdatedValue?.let {
                if (DateTimeUtils.checkTimeDifference(
                        REMOTE_DATA_CALLER_INTERVAL,
                        it,
                        DateTimeUtils.getCurrentTimestamp()
                    )
                ) {
                    val remoteData = remoteRepository.fetchCurrencyList()
                    when (remoteData) {
                        is Resource.Success -> {
                            remoteData.data?.let {
                                it.currencies.let { hash ->
                                    val _currencyList = ArrayList<Currency>()
                                    if (hash.isNotEmpty()) {
                                        roomData.deleteAllCurrency()
                                        hash.forEach { (key, value) ->
                                            val currency = Currency(key, value)
                                            _currencyList.add(currency)
                                            roomData.insertCurrency(currency)
                                        }
                                        emit(Resource.Success(data = _currencyList))
                                        localRepository.saveLastUpdatedDate(
                                            SHARED_CURRENCY_LAST_UPDATED,DateTimeUtils.getCurrentTimestamp())
                                    }
                                }
                            }
                        }
                        else -> {
                            emit(remoteData)
                        }
                    }

                } else {
                    val localCurrencyList = arrayListOf<Currency>()
                    localCurrencyList.addAll(roomData.getAllCurrencyList())
                    emit(Resource.Success(data = localCurrencyList))
                }
            }
        }.flowOn(ioDispatcher)
    }


    override suspend fun getExchangeRates(sourceCurrencyValue  : String ): Flow<Resource<out Any>> {
        return flow {
            val lastUpdatedValue = localRepository.getLastUpdatedDate(SHARED_EXCHANGE_LAST_UPDATED).data
            lastUpdatedValue?.let {
                if (DateTimeUtils.checkTimeDifference(
                        REMOTE_DATA_CALLER_INTERVAL,
                        it,
                        DateTimeUtils.getCurrentTimestamp()
                    )
                ) {
                    val remoteData = remoteRepository.fetchExchangeRates()
                    when (remoteData) {
                        is Resource.Success -> {
                            remoteData.data?.let {
                                it.rates.let { hash ->
                                    val _exchangeRatesList = ArrayList<ExchangeRates>()
                                    if (hash.isNotEmpty()) {
                                        roomData.deleteAllExchangeRates()
                                        hash.forEach { (key, value) ->
                                            val exchangeRate = ExchangeRates(
                                                sourceCurrency = sourceCurrencyValue,
                                                destinationCurrency = key.removeRange(0,2),
                                                    rate= value
                                            )
                                            _exchangeRatesList.add(exchangeRate)
                                            roomData.insertExchangeRate(exchangeRate)
                                        }
                                        emit(Resource.Success(data = _exchangeRatesList))
                                        localRepository.saveLastUpdatedDate(
                                            SHARED_EXCHANGE_LAST_UPDATED,DateTimeUtils.getCurrentTimestamp())
                                    }
                                }
                            }
                        }
                        else -> {
                            emit(remoteData)
                        }
                    }

                } else {
                    val localExchangeList = arrayListOf<ExchangeRates>()
                    localExchangeList.addAll(roomData.getExchangeRates(sourceCurrencyValue))
                    emit(Resource.Success(data = localExchangeList))
                }
            }
        }.flowOn(ioDispatcher)
    }
}