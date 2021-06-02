package com.vishnu_mulik.currencyconverter.data.localData.room

import androidx.room.*
import com.vishnu_mulik.currencyconverter.data.models.Currency


/**
 * CREATED BY Vishnu Mulik  ON  31/05/21
 */
@Dao
interface CurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrency(currency: Currency)

    @Delete
    suspend fun delete(currency: Currency)

    @Query("DELETE FROM Currency")
    suspend fun deleteAll()

    @Query("SELECT * FROM Currency")
    fun getAllCurrency(): List<Currency>
}