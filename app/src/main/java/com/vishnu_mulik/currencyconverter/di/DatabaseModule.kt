package com.vishnu_mulik.currencyconverter.di

import android.content.Context
import androidx.room.Room
import com.vishnu_mulik.currencyconverter.data.localData.room.AppDatabase
import com.vishnu_mulik.currencyconverter.data.localData.room.CurrencyDao
import com.vishnu_mulik.currencyconverter.data.localData.room.ExchangeRatesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * CREATED BY Vishnu Mulik  ON  31/05/21
 */

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "app.db"
        ).build()
    }

    @Provides
    fun provideCurrencyDao(appDatabase: AppDatabase): CurrencyDao {
        return appDatabase.currencyDao()
    }

    @Provides
    fun provideExchangeRateDao(appDatabase: AppDatabase): ExchangeRatesDao {
        return appDatabase.exchangeRatesDao()
    }
}