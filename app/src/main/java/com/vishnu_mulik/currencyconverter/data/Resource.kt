package com.vishnu_mulik.currency_conversion.data


/**
 * CREATED BY Vishnu Mulik  ON  29/05/21
 */

sealed class Resource<T>( val data : T? = null ,val errorCode : Int ? =null){
   class Success<T> (data: T?) : Resource<T>(data)
   class Loading <T> (data: T? = null) : Resource<T>(data)
   class Error <T>(errorCode: Int?) : Resource<T>(null, errorCode)
}
