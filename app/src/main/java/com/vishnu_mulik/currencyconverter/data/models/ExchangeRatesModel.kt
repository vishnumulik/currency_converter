package  com.vishnu_mulik.currencyconverter.data.models

import com.squareup.moshi.Json


/**
 * CREATED BY Vishnu Mulik  ON  30/05/21
 */
data class ExchangeRatesModel(
    @field:Json(name = "success")
    val success: Boolean,
    @field:Json(name = "terms")
    val terms: String,
    @field:Json(name = "privacy")
    val privacy: String,
    @field:Json(name = "timestamp")
    val timestamp: Long,
    @field:Json(name = "source")
    val source: String,
    @field:Json(name = "quotes")
    val quotes: Map<String, Double>,
    @field:Json(name = "error")
    val error: Error

)
