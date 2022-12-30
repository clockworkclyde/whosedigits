package com.github.clockworkclyde.whosedigits.ui.screens.bin

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.github.clockworkclyde.whosedigits.domain.bin.SearchDataWithBinUseCase
import com.github.clockworkclyde.whosedigits.models.SEARCH_BIN_DEBOUNCE
import com.github.clockworkclyde.whosedigits.models.WHILE_SUBSCRIBED_TIMEOUT
import com.github.clockworkclyde.whosedigits.models.base.Response
import com.github.clockworkclyde.whosedigits.models.ui.BinData
import com.github.clockworkclyde.whosedigits.ui.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class SearchBinViewModel @Inject constructor(
    private val searchBin: SearchDataWithBinUseCase
) : BaseViewModel() {

    private val _searchQuery = MutableStateFlow("")
    private val _errorMessage = MutableSharedFlow<String>()
    private val _isLoading = MutableStateFlow(false)

    val searchQuery = _searchQuery.asStateFlow()
    val errorMessage = _errorMessage.asSharedFlow()
    val isLoading = _isLoading.asStateFlow()

    fun updateQuery(query: String) {
        _searchQuery.value = query
    }

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val searchResult: SharedFlow<BinData> by lazy {
        _searchQuery
            .debounce(SEARCH_BIN_DEBOUNCE)
            .filter { it.trim().isNotEmpty() }
            .flatMapLatest { bin ->
                flow {
                    searchBin(bin).let {
                        Log.e("TAG", it.toString())
                        when (it) {
                            is Response.Failure -> _errorMessage.emit("Request error: ${it.exception}")
                            is Response.Success -> emit(it.data)
                        }
                    }
                }
            }
            .shareIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(WHILE_SUBSCRIBED_TIMEOUT),
                replay = 1
            )
    }

}