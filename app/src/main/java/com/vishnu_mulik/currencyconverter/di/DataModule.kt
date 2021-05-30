package com.vishnu_mulik.currencyconverter.di

import com.vishnu_mulik.currencyconverter.data.DataRepository
import com.vishnu_mulik.currencyconverter.data.DataRepositorySource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideDataRepository(dataRepository: DataRepository): DataRepositorySource
}
