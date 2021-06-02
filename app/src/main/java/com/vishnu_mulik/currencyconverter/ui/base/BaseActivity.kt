package com.vishnu_mulik.currencyconverter.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
abstract class BaseActivity : AppCompatActivity() {
    abstract fun initViewBinding()
    protected abstract fun observeViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        observeViewModels()
    }

}