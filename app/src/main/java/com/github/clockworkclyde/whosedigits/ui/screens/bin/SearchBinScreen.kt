package com.github.clockworkclyde.whosedigits.ui.screens.bin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.github.clockworkclyde.whosedigits.ui.composables.search.SearchBar

@Composable
fun SearchBinScreen(viewModel: SearchBinViewModel) {
    val result = viewModel.searchResult.collectAsState(initial = null).value
    val searchQuery = viewModel.searchQuery.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value

    var isFocused by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar(
            query = searchQuery,
            onQueryTextChange = { viewModel.updateQuery(it) },
            onFocusSearchChange = { isFocused = it },
            onClearQuery = { viewModel.updateQuery("") },
            onBack = { /*TODO*/ },
            loading = isLoading,
            focused = isFocused
        )

        Text(text = result.toString())
    }
}