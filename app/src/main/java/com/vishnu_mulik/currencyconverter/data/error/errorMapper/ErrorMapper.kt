package com.vishnu_mulik.currencyconverter.data.error.errorMapper

import android.content.Context
import com.vishnu_mulik.currencyconverter.R
import com.vishnu_mulik.currencyconverter.data.error.NO_INTERNET_CONNECTION
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
class ErrorMapper @Inject constructor (@ApplicationContext val context : Context) : ErrorMapperSource {
    override fun getErrorString(errorId: Int): String {
        return context.getString(errorId)
    }

    override val errorMap: Map<Int, String>
        get() = mapOf(
            Pair(NO_INTERNET_CONNECTION, getErrorString(R.string.error_no_internet_connection))
        )
}