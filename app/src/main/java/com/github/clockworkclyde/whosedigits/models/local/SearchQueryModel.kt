package com.github.clockworkclyde.whosedigits.models.local

data class SearchQueryModel(
    val bin: Int,
    val country: String = "",
    val bank: String = ""
)