package com.vishnu_mulik.currencyconverter.data.remote

import com.vishnu_mulik.currency_conversion.data.Resource
import com.vishnu_mulik.currencyconverter.data.models.Currency
import com.vishnu_mulik.currencyconverter.data.models.CurrencyModel
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRatesModel


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
interface RemoteDataSource {
    suspend fun fetchCurrencyList() : Resource<CurrencyModel>
    suspend fun fetchExchangeRates() : Resource<ExchangeRatesModel>
}