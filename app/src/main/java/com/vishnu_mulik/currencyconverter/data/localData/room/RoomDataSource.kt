package com.vishnu_mulik.currencyconverter.data.localData.room

import com.vishnu_mulik.currencyconverter.data.models.Currency
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRates


/**
 * CREATED BY Vishnu Mulik  ON  31/05/21
 */
interface RoomDataSource {

    suspend fun insertCurrency(currency: Currency)
    suspend fun deleteAllCurrency()
    suspend fun getAllCurrencyList(): List<Currency>
    suspend fun insertExchangeRate(exchangeRate: ExchangeRates)
    suspend fun getExchangeRates(source: String): List<ExchangeRates>
    suspend fun deleteAllExchangeRates()
}