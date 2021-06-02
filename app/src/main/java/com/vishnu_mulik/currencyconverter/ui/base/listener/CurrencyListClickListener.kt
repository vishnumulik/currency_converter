package com.vishnu_mulik.currencyconverter.ui.base.listener

import com.vishnu_mulik.currencyconverter.data.models.ExchangeRates


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */


interface CurrencyListClickListener {
    fun onItemSelected(exchangeRates: ExchangeRates)
}