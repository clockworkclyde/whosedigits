package com.github.clockworkclyde.whosedigits.domain

import com.github.clockworkclyde.whosedigits.models.base.Response
import com.github.clockworkclyde.whosedigits.models.ui.BinData

interface BinRepository {
    suspend fun search(bin: Int): Response<BinData>
}