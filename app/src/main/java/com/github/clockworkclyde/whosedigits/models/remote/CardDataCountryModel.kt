package com.github.clockworkclyde.whosedigits.models.remote

import com.google.gson.annotations.SerializedName

data class CardDataCountryModel(
    @SerializedName("numeric") val numeric: String,
    @SerializedName("alpha2") val short: String,
    @SerializedName("name") val name: String,
    @SerializedName("latitude") val lat: Float,
    @SerializedName("longitude") val lng: Float,
    @SerializedName("currency") val currency: String
)
