package com.vishnu_mulik.currencyconverter.ui.components.currencyList

import android.R
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.vishnu_mulik.currency_conversion.data.Resource
import com.vishnu_mulik.currencyconverter.data.models.Currency
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRates
import com.vishnu_mulik.currencyconverter.databinding.ActivityCurrencyListBinding
import com.vishnu_mulik.currencyconverter.ui.base.BaseActivity
import com.vishnu_mulik.currencyconverter.ui.components.currencyList.adapters.CurrencyListAdapter
import com.vishnu_mulik.currencyconverter.ui.components.currencyList.coversion_dialog.ConversionDialog
import com.vishnu_mulik.currencyconverter.utils.observe
import com.vishnu_mulik.currencyconverter.utils.toGone
import com.vishnu_mulik.currencyconverter.utils.toVisible
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CurrencyListActivity : BaseActivity() {
    private lateinit var binding: ActivityCurrencyListBinding
    private val currencyListViewModel: CurrencyListViewModel by viewModels()
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
        observe(currencyListViewModel.currencyListLivedata, ::handlecurrencyList)
        observe(currencyListViewModel.showConvertDialog, ::showConvertdialog)
        observe(currencyListViewModel.exchangeListLivedata ,::handleExchangeList)
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvCurrencyList.layoutManager = layoutManager
        binding.rvCurrencyList.setHasFixedSize(true)
    }

    private fun showLoadingView() {
        binding.pbLoading.toVisible()
        binding.tvNoData.toGone()
    }

    private fun handlecurrencyList(status: Resource<out Any>) {
        when (status) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> {
                status.data?.let { bindCurrencyList(list = it as ArrayList<Currency>) }
            }
            is Resource.DataError -> {
                showDataView(false)
                status.errorCode?.let { currencyListViewModel.showToastMessage(it) }
            }
        }
    }
    private fun handleExchangeList(status: Resource<out Any>) {
        when (status) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> {
                status.data?.let { bindExchangeListData(list = it as ArrayList<ExchangeRates>) }
            }
            is Resource.DataError -> {
                showDataView(false)
                status.errorCode?.let { currencyListViewModel.showToastMessage(it) }
            }
        }
    }
    private fun showConvertdialog(rate : Double){
        val dialog = ConversionDialog.newInstance(rate =rate )
        dialog.show(supportFragmentManager,"ConversionDialog")
    }

    private fun bindCurrencyList(list: ArrayList<Currency>) {
        if (list.isNotEmpty()) {
            val currencyNames = currencyListViewModel.getCurrencyNames(list)
            val arrayAdapterSource: ArrayAdapter<String> =
                ArrayAdapter<String>(this, R.layout.simple_dropdown_item_1line, currencyNames)
            binding.sourceCuurency.setAdapter(arrayAdapterSource)
            binding.sourceCuurency.threshold = 2
            binding.sourceCuurency.setOnItemClickListener { parent, arg1, position, arg3 ->
                currencyListViewModel.fetchExchangeRates(list.get(position).currencyname)
            }
        }
    }

    private fun bindExchangeListData(list: ArrayList<ExchangeRates>) {
        if (!(list.isNullOrEmpty())) {
            currencyListAdapter = CurrencyListAdapter(currencyListViewModel, list)
            binding.rvCurrencyList.adapter = currencyListAdapter
            showDataView(true)
        } else {
            showDataView(false)
        }
    }

    private fun showDataView(show: Boolean) {
        binding.tvNoData.visibility = if (show) View.GONE else View.VISIBLE
        binding.rvCurrencyList.visibility = if (show) View.VISIBLE else View.GONE
        binding.pbLoading.toGone()
    }

}