package com.vishnu_mulik.currencyconverter.ui.components.currencyList.adapters

import androidx.recyclerview.widget.RecyclerView
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRates
import com.vishnu_mulik.currencyconverter.databinding.ItemCurrencyListBinding
import com.vishnu_mulik.currencyconverter.ui.base.listener.CurrencyListClickListener
import kotlinx.android.synthetic.main.item_currency_list.view.*


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
class CurrencyListViewHolder(private val binding: ItemCurrencyListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(exchnageRate : ExchangeRates,  recyclerItemListener: CurrencyListClickListener) {
        binding.root.item_currency.text = exchnageRate.destinationCurrency + " " +  exchnageRate.rate
        binding.root.root_layout.setOnClickListener{recyclerItemListener.onItemSelected(exchangeRates =exchnageRate )}
     }
}