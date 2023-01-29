package com.github.clockworkclyde.whosedigits.providers.local

import com.chibatching.kotpref.KotprefModel

class SearchQueryProvider : KotprefModel() {

    private val items by stringSetPref()

    fun getQuerySet() = items.toSet()

    fun addQuery(item: String) = items.add(item)
}