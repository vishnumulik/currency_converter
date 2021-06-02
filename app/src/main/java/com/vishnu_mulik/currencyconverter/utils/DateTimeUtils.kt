package com.vishnu_mulik.currencyconverter.utils

import java.text.SimpleDateFormat
import java.util.*


/**
 * CREATED BY Vishnu Mulik  ON  31/05/21
 */
object DateTimeUtils {

    fun String.getStringDate(
        initialFormat: String,
        requiredFormat: String,
        locale: Locale = Locale.getDefault()
    ): String {
        return this.toDate(initialFormat, locale).toString(requiredFormat, locale)
    }

    fun String.toDate(format: String, locale: Locale = Locale.getDefault()): Date =
        SimpleDateFormat(format, locale).parse(this)


    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

    fun getCurrentTimestamp(): Long {
        return System.currentTimeMillis()
    }

    fun checkTimeDifference(interval: Int, startTime: Long, endTime: Long): Boolean {
        val diff: Long = endTime - startTime
        if (diff >= interval * 60 * 1000) {
            return true
        }
        return false
    }
}

