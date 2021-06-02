package com.vishnu_mulik.currencyconverter.data.localData.room

import androidx.room.*
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRates


/**
 * CREATED BY Vishnu Mulik  ON  31/05/21
 */
@Dao
interface ExchangeRatesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExchangeRate(exchangeRate: ExchangeRates)

    @Delete
    suspend fun delete(exchangeRate: ExchangeRates)

    @Query("DELETE FROM ExchangeRates")
    suspend fun deleteAll()

    @Query("SELECT * FROM ExchangeRates WHERE source_currency LIKE :sourceCurrency ")
    fun getExchangeRates(sourceCurrency: String): List<ExchangeRates>
}