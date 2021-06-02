package com.vishnu_mulik.currencyconverter.data

import com.vishnu_mulik.currency_conversion.data.Resource
import kotlinx.coroutines.flow.Flow


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
interface DataRepositorySource {

    /*This will check the last fetched time stamp and if the difference is greater than
     REMOTE_DATA_CALLER_INTERVAL then api call is invoked else data stored in the
     room database is returned*/
    suspend fun getCurrencyList(): Flow<Resource<out Any>>

    /*This will check the last fetched time stamp and if the difference is greater than
     REMOTE_DATA_CALLER_INTERVAL then api call is invoked else data stored in the
     room database is returned. The api basically fetches all the exchange rates
     of the currency passed */
    suspend fun getExchangeRates(source: String): Flow<Resource<out Any>>
}