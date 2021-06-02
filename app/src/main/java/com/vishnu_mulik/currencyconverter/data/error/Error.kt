package com.vishnu_mulik.currencyconverter.data.error


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
class Error(val code: Int, val errorDescription: String) {
    constructor(exception: Exception) : this(
        code = DEFAULT_ERROR,
        errorDescription = exception.message ?: ""
    )
}

const val NO_INTERNET_CONNECTION = -1
const val NETWORK_ERROR = -2
const val DEFAULT_ERROR = -3
const val UN_EXPECTED_RESPONSE = -4
const val CHECK_YOUR_FIELDS = -103
const val SEARCH_ERROR = -104