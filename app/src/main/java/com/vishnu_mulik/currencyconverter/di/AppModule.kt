package com.vishnu_mulik.currencyconverter.di

import android.content.Context
import com.vishnu_mulik.currencyconverter.data.localData.SharedPrefrenceData
import com.vishnu_mulik.currencyconverter.data.remote.ServiceGenerator
import com.vishnu_mulik.currencyconverter.utils.Network
import com.vishnu_mulik.currencyconverter.utils.NetworkConnectivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideLocalRepository(@ApplicationContext context: Context): SharedPrefrenceData {
        return SharedPrefrenceData(context)
    }

    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext {
        return Dispatchers.IO
    }

    @Provides
    @Singleton
    fun provideNetworkConnectivity(@ApplicationContext context: Context): NetworkConnectivity {
        return Network(context)
    }


}
