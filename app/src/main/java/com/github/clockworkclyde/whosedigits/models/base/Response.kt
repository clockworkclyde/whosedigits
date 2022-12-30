package com.github.clockworkclyde.whosedigits.models.base

sealed class Response<out T> {
    data class Success<T>(val data: T) : Response<T>()
    data class Failure(val exception: Throwable) : Response<Nothing>()
}