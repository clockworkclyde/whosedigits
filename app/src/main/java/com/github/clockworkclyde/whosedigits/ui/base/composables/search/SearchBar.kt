package com.github.clockworkclyde.whosedigits.ui.base.composables.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    query: String,
    onQueryTextChange: (String) -> Unit,
    onFocusSearchChange: (Boolean) -> Unit,
    onClearQuery: () -> Unit,
    onBack: () -> Unit,
    loading: Boolean,
    focused: Boolean,
    modifier: Modifier = Modifier
) {

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AnimatedVisibility(visible = focused) {
            IconButton(onClick = {
                focusManager.clearFocus()
                keyboardController?.hide()
                onBack()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Go back from searchView"
                )
            }
        }
        SearchBinTextField(
            query = query,
            onQueryTextChange = onQueryTextChange,
            onFocusSearchChange = onFocusSearchChange,
            onClearQuery = onClearQuery,
            loading = loading,
            focused = focused,
            modifier = modifier.weight(1f)
        )
    }
}