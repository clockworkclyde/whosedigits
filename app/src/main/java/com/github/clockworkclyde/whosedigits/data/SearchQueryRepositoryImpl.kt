package com.github.clockworkclyde.whosedigits.data

import com.github.clockworkclyde.whosedigits.domain.SearchQueryRepository
import com.github.clockworkclyde.whosedigits.models.local.SearchQueryModel
import com.github.clockworkclyde.whosedigits.models.ui.BinData
import com.github.clockworkclyde.whosedigits.providers.local.SearchQueryProvider
import com.google.gson.Gson
import javax.inject.Inject

class SearchQueryRepositoryImpl @Inject constructor(
   private val queryProvider: SearchQueryProvider,
   private val gson: Gson
) : SearchQueryRepository {

   override fun getQueriesBin(): List<Int> {
      return queryProvider.getQuerySet().map {
         gson.fromJson(it, SearchQueryModel::class.java).bin
      }
   }

   override fun addQuery(bin: Int, data: BinData) {
      val model = SearchQueryModel(bin = bin, country = data.country.name, bank = data.bank.name)
      queryProvider.addQuery(gson.toJson(model))
   }
}