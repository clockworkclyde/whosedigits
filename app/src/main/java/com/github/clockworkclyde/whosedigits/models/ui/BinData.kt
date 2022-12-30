package com.github.clockworkclyde.whosedigits.models.ui

import com.github.clockworkclyde.whosedigits.models.remote.BinDataBankModel
import com.github.clockworkclyde.whosedigits.models.remote.BinDataCountryModel
import com.github.clockworkclyde.whosedigits.models.remote.BinDataNumberModel

data class BinData(
    val number: BinDataNumberModel,
    val scheme: String,
    val cardType: String,
    val brand: String,
    val prepaid: Boolean,
    val country: BinDataCountryModel,
    val bank: BinDataBankModel
) {

}
