package com.vishnu_mulik.currencyconverter.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * CREATED BY Vishnu Mulik  ON  31/05/21
 */
@Entity(tableName = "Currency")
data class Currency(

    @ColumnInfo(name = "currency_name")
    var currencyname: String,

    @ColumnInfo(name = "code")
    var code: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null

}