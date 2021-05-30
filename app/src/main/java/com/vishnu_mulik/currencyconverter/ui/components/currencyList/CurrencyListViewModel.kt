package com.vishnu_mulik.currencyconverter.ui.components.currencyList

import android.util.Log
import androidx.lifecycle.viewModelScope
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
public class CurrencyListViewModel
@Inject
constructor(private val dataRepository: DataRepositorySource)  : BaseViewModel() {

    init {
        fetchCurrencyList()
    }

     fun fetchCurrencyList(){
        viewModelScope.launch {
           dataRepository.getCurrencyList().collect {
               Log.d("value ", " value")
           }


        }

    }
}