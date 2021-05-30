package com.vishnu_mulik.currencyconverter.data.error


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
interface ErrorUseCase {
    fun getError(errorCode: Int): Error
}