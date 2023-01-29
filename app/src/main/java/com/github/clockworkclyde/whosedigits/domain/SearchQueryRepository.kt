package com.github.clockworkclyde.whosedigits.domain

import com.github.clockworkclyde.whosedigits.models.ui.BinData

interface SearchQueryRepository {
   fun getQueriesBin(): List<Int>
   fun addQuery(bin: Int, data: BinData)
}