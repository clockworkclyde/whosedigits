package com.github.clockworkclyde.whosedigits.data

import com.github.clockworkclyde.whosedigits.domain.BinRepository
import com.github.clockworkclyde.whosedigits.models.base.Response
import com.github.clockworkclyde.whosedigits.models.ui.BinData
import com.github.clockworkclyde.whosedigits.providers.remote.BinApi
import javax.inject.Inject

class BinRepositoryImpl @Inject constructor(private val api: BinApi) : BinRepository {

    override suspend fun search(bin: Int): Response<BinData> {
        return try {
            Response.Success(api.requestBinData(bin).convertTo())
        } catch (e: Exception) {
            Response.Failure(e)
        }
    }
}