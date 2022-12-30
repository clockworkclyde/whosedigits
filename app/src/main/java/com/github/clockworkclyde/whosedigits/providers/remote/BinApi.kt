package com.github.clockworkclyde.whosedigits.providers.remote

import com.github.clockworkclyde.whosedigits.models.remote.BinDataModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface BinApi {

    @GET("/{bin}")
    suspend fun requestBinData(@Path("bin") bin: Int): BinDataModel

}