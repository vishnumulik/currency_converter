package com.vishnu_mulik.currencyconverter.ui.components.currencyList.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vishnu_mulik.currencyconverter.data.models.Currency
import com.vishnu_mulik.currencyconverter.data.models.ExchangeRates
import com.vishnu_mulik.currencyconverter.databinding.ItemCurrencyListBinding
import com.vishnu_mulik.currencyconverter.ui.base.listener.CurrencyListClickListener
import com.vishnu_mulik.currencyconverter.ui.components.currencyList.CurrencyListViewModel


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
class CurrencyListAdapter(private val currencyListViewModel : CurrencyListViewModel,
                          private val data : ArrayList<ExchangeRates>)  :
    RecyclerView.Adapter<CurrencyListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyListViewHolder {
        val itemBinding = ItemCurrencyListBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return CurrencyListViewHolder(itemBinding)
    }
    override fun onBindViewHolder(holder: CurrencyListViewHolder, position: Int) {
        holder.bind(data.get(position),onItemClickListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }
    private val onItemClickListener: CurrencyListClickListener = object : CurrencyListClickListener {
        override fun onItemSelected(exchangeRates: ExchangeRates) {
            currencyListViewModel.openConverterDialog(exchangeRates.rate)
        }
    }
}