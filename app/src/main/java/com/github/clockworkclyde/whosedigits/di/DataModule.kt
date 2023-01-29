package com.github.clockworkclyde.whosedigits.di

import com.github.clockworkclyde.whosedigits.data.BinRepositoryImpl
import com.github.clockworkclyde.whosedigits.data.SearchQueryRepositoryImpl
import com.github.clockworkclyde.whosedigits.domain.BinRepository
import com.github.clockworkclyde.whosedigits.domain.SearchQueryRepository
import com.github.clockworkclyde.whosedigits.providers.local.SearchQueryProvider
import com.github.clockworkclyde.whosedigits.providers.remote.BinApi
import com.google.gson.Gson
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

   @Provides
   @Singleton
   fun provideSearchQueryProvider() = SearchQueryProvider()

   @Provides
   @Singleton
   fun provideSearchQueryRepository(
      provider: SearchQueryProvider,
      gson: Gson
   ): SearchQueryRepository = SearchQueryRepositoryImpl(provider, gson)

   @Provides
   @Singleton
   fun provideGson(): Gson = Gson()
}