package com.github.clockworkclyde.whosedigits.models.remote

import com.github.clockworkclyde.whosedigits.models.base.IConvertableTo
import com.github.clockworkclyde.whosedigits.models.ui.BinData
import com.google.gson.annotations.SerializedName

data class BinDataModel(
    @SerializedName("number") val number: BinDataNumberModel,
    @SerializedName("scheme") val scheme: String,
    @SerializedName("type") val cardType: String,
    @SerializedName("brand") val brand: String,
    @SerializedName("prepaid") val prepaid: Boolean,
    @SerializedName("country") val country: BinDataCountryModel,
    @SerializedName("bank") val bank: BinDataBankModel
) : IConvertableTo<BinData> {

    override fun convertTo(): BinData {
        return BinData(
            number = number,
            scheme = scheme,
            cardType = cardType,
            brand = brand,
            prepaid = prepaid,
            country = country,
            bank = bank
        )
    }
}