package com.vishnu_mulik.currencyconverter.ui.components.currencyList

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vishnu_mulik.currency_conversion.data.Resource
import com.vishnu_mulik.currencyconverter.data.DataRepositorySource
import com.vishnu_mulik.currencyconverter.data.models.Currency
import com.vishnu_mulik.currencyconverter.ui.base.BaseViewModel
import com.vishnu_mulik.currencyconverter.utils.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
@HiltViewModel
class CurrencyListViewModel
@Inject
constructor(private val dataRepository: DataRepositorySource) : BaseViewModel() {


    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val currencyListLiveDataPrivate = MutableLiveData<Resource<out Any>>()
    val currencyListLivedata: MutableLiveData<Resource<out Any>> get() = currencyListLiveDataPrivate


    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val exchangeListLiveDataPrivate = MutableLiveData<Resource<out Any>>()
    val exchangeListLivedata: MutableLiveData<Resource<out Any>> get() = exchangeListLiveDataPrivate


    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showToastPrivate = MutableLiveData<SingleEvent<Any>>()
    val showToast: LiveData<SingleEvent<Any>> get() = showToastPrivate

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showConvertDialogPrivate = MutableLiveData<Double>()
    val showConvertDialog: MutableLiveData<Double> get() = showConvertDialogPrivate


    init {
        fetchCurrencyList()
    }


    fun fetchCurrencyList() {
        viewModelScope.launch {
            dataRepository.getCurrencyList().collect {
                currencyListLivedata.value = it
            }
        }

    }

    fun fetchExchangeRates(source: String) {
        viewModelScope.launch {
            dataRepository.getExchangeRates(source = source).collect{
                exchangeListLivedata.value = it
            }
        }
    }

    fun showToastMessage(errorCode: Int) {
        val error = errorManager.getError(errorCode)
        showToastPrivate.value = SingleEvent(error.errorDescription)
    }

    fun getCurrencyNames(list: ArrayList<Currency>): ArrayList<String> {
        val returnValue = ArrayList<String>()
        list.forEach { returnValue.add(it.code) }
        return returnValue
    }

    fun openConverterDialog(rate : Double){
        showConvertDialog.value =rate
    }


}