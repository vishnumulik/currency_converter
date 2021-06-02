package com.vishnu_mulik.currencyconverter.data.localData.room

import com.vishnu_mulik.currencyconverter.data.models.Currency
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


/**
 * CREATED BY Vishnu Mulik  ON  31/05/21
 */
class RoomData
@Inject constructor(
    private val appDatabase: AppDatabase,
    private val ioDispatcher: CoroutineContext
) : RoomDataSource {

    override suspend fun insertCurrency(currency: Currency) {
        withContext(ioDispatcher) {
            appDatabase.currencyDao().insertCurrency(currency)
        }
    }

    override suspend fun deleteAllCurrency() {
        withContext(ioDispatcher) {
            appDatabase.currencyDao().deleteAll()
        }
    }

    override suspend fun getAllCurrencyList(): List<Currency> = withContext(ioDispatcher) {
        appDatabase.currencyDao().getAllCurrency()
    }

    override suspend fun insertExchangeRate(exchangeRate: ExchangeRates) {
        appDatabase.exchangeRatesDao().insertExchangeRate(exchangeRate)
    }

    override suspend fun getExchangeRates(
        source: String
    ): List<ExchangeRates> =withContext(ioDispatcher){
        appDatabase.exchangeRatesDao().getExchangeRates(source)
    }

    override suspend fun deleteAllExchangeRates() {
        appDatabase.exchangeRatesDao().deleteAll()
    }


}