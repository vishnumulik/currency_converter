package com.vishnu_mulik.currencyconverter.utils

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


/**
 * CREATED BY Vishnu Mulik  ON  31/05/21
 */
object DateTimeUtils
 {

    fun String.getStringDate(initialFormat: String, requiredFormat: String, locale: Locale = Locale.getDefault()): String {
        return this.toDate(initialFormat, locale).toString(requiredFormat, locale)
    }

    fun String.toDate(format: String, locale: Locale = Locale.getDefault()): Date = SimpleDateFormat(format, locale).parse(this)


    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

    fun getCurrentTimestamp() : Long {
        return   System.currentTimeMillis()
    }
}

