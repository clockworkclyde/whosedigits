package com.github.clockworkclyde.whosedigits.ui.composables.search

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import com.github.clockworkclyde.whosedigits.models.ui.BinData

//@Stable
//class SearchBinState(
//    query: TextFieldValue,
//    focused: Boolean,
//    loading: Boolean,
//    historySuggestions: List<String>,
//    searchResult: List<BinData>
//) {
//    var query by mutableStateOf(query)
//    var focused by mutableStateOf(focused)
//    var loading by mutableStateOf(loading)
//    var historySuggestions by mutableStateOf(historySuggestions)
//    var searchResult by mutableStateOf(searchResult)
//
//    val searchState: SearchState
//        get() = when {
//            !focused && query.text.isEmpty() -> SearchState.Initial
//            focused && query.text.isEmpty() -> SearchState.Suggestions
//            searchResult.isEmpty() -> SearchState.NoResult
//            else -> SearchState.Result
//        }
//
//    override fun toString(): String {
//        return "State: query: $query, isFocused: $focused, isLoading: $loading, search suggestions: $historySuggestions, result: $searchResult"
//    }
//}