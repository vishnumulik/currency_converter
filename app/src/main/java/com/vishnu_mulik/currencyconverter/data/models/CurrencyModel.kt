package com.vishnu_mulik.currencyconverter.data.models

import com.squareup.moshi.Json


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
data class CurrencyModel(
    @field:Json(name = "success")
    val success: Boolean,
    @field:Json(name = "terms")
    val terms: String,
    @field:Json(name = "privacy")
    val privacy: String,
    @field:Json(name = "success")
    val currencies: Map<String, String>

)
