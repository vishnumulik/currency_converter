package com.vishnu_mulik.currencyconverter.data.error.errorMapper


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
interface ErrorMapperSource {
    fun getErrorString(errorId: Int): String
    val errorMap: Map<Int, String>
}