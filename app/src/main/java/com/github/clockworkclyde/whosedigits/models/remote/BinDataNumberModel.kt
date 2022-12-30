package com.github.clockworkclyde.whosedigits.models.remote

import com.google.gson.annotations.SerializedName

data class BinDataNumberModel(
    @SerializedName("length") val fullLength: Int,
    @SerializedName("luhn") val luhn: Boolean
)