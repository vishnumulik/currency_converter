package com.vishnu_mulik.currencyconverter.data.localData.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vishnu_mulik.currencyconverter.data.models.Currency
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRates

/**
 * CREATED BY Vishnu Mulik  ON  31/05/21
 */
@Database(entities = [Currency::class, ExchangeRates::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
    abstract fun exchangeRatesDao(): ExchangeRatesDao
}