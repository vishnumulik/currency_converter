package com.vishnu_mulik.currencyconverter.data

import com.vishnu_mulik.currency_conversion.data.Resource
import com.vishnu_mulik.currencyconverter.data.models.CurrencyModel
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRatesModel
import kotlinx.coroutines.flow.Flow


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
interface DataRepositorySource {
    suspend fun getCurrencyList(): Flow<Resource<CurrencyModel>>
    suspend fun getExchangeRates() : Flow<Resource<ExchangeRatesModel>>
}