package com.github.clockworkclyde.whosedigits.di

import com.github.clockworkclyde.whosedigits.data.BinRepositoryImpl
import com.github.clockworkclyde.whosedigits.domain.BinRepository
import com.github.clockworkclyde.whosedigits.providers.remote.BinApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideBinRepository(api: BinApi): BinRepository = BinRepositoryImpl(api)

}