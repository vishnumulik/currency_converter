package com.vishnu_mulik.currencyconverter.data.error

import com.vishnu_mulik.currencyconverter.data.error.errorMapper.ErrorMapper
import javax.inject.Inject


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
class ErrorManager @Inject constructor(private val errorMapper: ErrorMapper) : ErrorUseCase {
    override fun getError(errorCode: Int): Error {
        return Error(code = errorCode, errorDescription = errorMapper.errorMap.getValue(errorCode))
    }

}