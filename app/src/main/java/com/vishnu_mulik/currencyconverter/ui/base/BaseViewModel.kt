package com.vishnu_mulik.currencyconverter.ui.base

import androidx.lifecycle.ViewModel
import com.vishnu_mulik.currencyconverter.data.error.ErrorManager
import javax.inject.Inject


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
abstract  class BaseViewModel : ViewModel() {
    @Inject
    lateinit var errorManager: ErrorManager
}