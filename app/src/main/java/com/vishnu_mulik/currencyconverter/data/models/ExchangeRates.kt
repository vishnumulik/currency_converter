package com.vishnu_mulik.currencyconverter.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * CREATED BY Vishnu Mulik  ON  31/05/21
 */
@Entity(tableName = "ExchangeRates")
data class ExchangeRates(

    @ColumnInfo(name = "source_currency")
    var sourceCurrency: String,

    @ColumnInfo(name = "destination_currency")
    var destinationCurrency: String,

    @ColumnInfo(name = "rate")
    var rate: Double
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null
}