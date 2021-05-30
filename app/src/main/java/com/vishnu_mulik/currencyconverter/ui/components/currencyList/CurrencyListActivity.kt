package com.vishnu_mulik.currencyconverter.ui.components.currencyList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.vishnu_mulik.currencyconverter.databinding.ActivityCurrencyListBinding
import com.vishnu_mulik.currencyconverter.ui.base.BaseActivity
import com.vishnu_mulik.currencyconverter.ui.components.currencyList.adapters.CurrencyListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyListActivity : BaseActivity() {
    private lateinit var binding : ActivityCurrencyListBinding
    private val  currencyListViewModel : CurrencyListViewModel by viewModels()
    private lateinit var currencyListAdapter: CurrencyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "CurrencyConverter"
        initRecyclerView()
    }

    override fun initViewBinding() {
        binding = ActivityCurrencyListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun observeViewModels() {
        currencyListViewModel.fetchCurrencyList()
    }

    private fun initRecyclerView(){
        val layoutManager = LinearLayoutManager(this)
        binding.rvCurrencyList.layoutManager = layoutManager
        binding.rvCurrencyList.setHasFixedSize(true)
    }



}