package com.vishnu_mulik.currencyconverter.data.localData

import android.content.Context
import android.content.SharedPreferences
import com.vishnu_mulik.currency_conversion.data.Resource
import com.vishnu_mulik.currencyconverter.data.SHARED_PREFERENCES_FILE_NAME
import javax.inject.Inject


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
class SharedPrefrenceData
@Inject constructor(val context: Context) {

    fun getLastUpdatedDate(key: String): Resource<Long> {
        val sharedPref = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, 0)
        val lastUpdatedValue = sharedPref.getLong(key, 0)
        return Resource.Success(lastUpdatedValue)
    }

    fun saveLastUpdatedDate(key: String, dateTimeValue: Long): Resource<Boolean> {
        val sharedPref = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, 0)
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putLong(key, dateTimeValue)
        editor.apply()
        val isSuccess = editor.commit()
        return Resource.Success(isSuccess)
    }
}