package com.github.clockworkclyde.whosedigits.providers.remote

import com.github.clockworkclyde.whosedigits.models.remote.CardDataModel
import retrofit2.http.GET

interface BinApi {

    @GET("/")
    suspend fun requestCardData(bin: Int): CardDataModel

}