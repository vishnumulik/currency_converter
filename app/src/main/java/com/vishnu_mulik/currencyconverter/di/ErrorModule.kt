package com.vishnu_mulik.currencyconverter.di

import com.vishnu_mulik.currencyconverter.data.error.ErrorManager
import com.vishnu_mulik.currencyconverter.data.error.ErrorUseCase
import com.vishnu_mulik.currencyconverter.data.error.errorMapper.ErrorMapper
import com.vishnu_mulik.currencyconverter.data.error.errorMapper.ErrorMapperSource
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
abstract class ErrorModule {
    @Binds
    @Singleton
    abstract fun provideErrorFactoryImpl(errorManager: ErrorManager): ErrorUseCase

    @Binds
    @Singleton
    abstract fun provideErrorMapper(errorMapper: ErrorMapper): ErrorMapperSource
}