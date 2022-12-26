package com.github.clockworkclyde.whosedigits.models.remote

import com.google.gson.annotations.SerializedName

data class CardDataModel(
    @SerializedName("number") val number: CardDataNumberModel,
    @SerializedName("scheme") val scheme: String,
    @SerializedName("type") val cardType: String,
    @SerializedName("brand") val brand: String,
    @SerializedName("prepaid") val prepaid: Boolean,
    @SerializedName("country") val country: CardDataCountryModel,
    @SerializedName("bank") val bank: CardDataBankModel

)