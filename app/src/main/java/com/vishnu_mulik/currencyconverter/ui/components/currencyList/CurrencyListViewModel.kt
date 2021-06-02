package com.vishnu_mulik.currencyconverter.ui.components.currencyList

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.vishnu_mulik.currency_conversion.data.Resource
import com.vishnu_mulik.currencyconverter.data.DataRepositorySource
import com.vishnu_mulik.currencyconverter.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

import kotlinx.coroutines.flow.collect

/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
@HiltViewModel
 class CurrencyListViewModel
@Inject
constructor(private val dataRepository: DataRepositorySource)  : BaseViewModel() {

    fun fetchCurrencyList(){
        viewModelScope.launch {
           dataRepository.getCurrencyList().collect {
               when (it) {
                   is Resource.Loading -> Log.d("value ", " loading ")
                   is Resource.Success -> Log.d("value ", " succcess")
                   is Resource.DataError -> {
                       Log.d("value ", " dataerror")
                   }
               }
           }


        }

    }
}