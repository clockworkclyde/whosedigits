package com.github.clockworkclyde.whosedigits.models.remote

import com.google.gson.annotations.SerializedName

data class BinDataBankModel(
    @SerializedName("name") val name: String = "",
    @SerializedName("url") val bankUrl: String = "",
    @SerializedName("phone") val phoneNumber: String = "",
    @SerializedName("city") val cityName: String = ""
)