package com.github.clockworkclyde.whosedigits.di

import com.github.clockworkclyde.whosedigits.BuildConfig
import com.github.clockworkclyde.whosedigits.providers.remote.BinApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BinApiModule {

    private const val REQUEST_TIMEOUT = 10L

    @Provides
    fun provideOkHttpBuilder(): OkHttpClient.Builder = OkHttpClient.Builder().apply {
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(httpLoggingInterceptor)
        }
        readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
        connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        httpBuilder: OkHttpClient.Builder,
        retrofitBuilder: Retrofit.Builder
    ): Retrofit = retrofitBuilder
        .client(httpBuilder.build())
        .build()

    @Provides
    @Singleton
    fun provideBinApi(retrofit: Retrofit): BinApi = retrofit.create(BinApi::class.java)
}