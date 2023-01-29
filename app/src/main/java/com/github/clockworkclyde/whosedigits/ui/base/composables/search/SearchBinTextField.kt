package com.github.clockworkclyde.whosedigits.ui.base.composables.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchBinTextField(
    query: String,
    onQueryTextChange: (String) -> Unit,
    onFocusSearchChange: (Boolean) -> Unit,
    onClearQuery: () -> Unit,
    loading: Boolean,
    focused: Boolean,
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }

    Surface(
        modifier = modifier.then(
            Modifier
                .height(56.dp)
                .padding(all = 8.dp)
        ),
        color = Color(0xffF5F5F5),
        shape = RoundedCornerShape(percent = 50)
    ) {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Box(modifier = modifier, contentAlignment = Alignment.CenterStart) {
                query.ifEmpty {
                    SearchHint(modifier = Modifier.padding(start = 24.dp, end = 8.dp))
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    BasicTextField(value = query, onValueChange = onQueryTextChange,
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .onFocusChanged { onFocusSearchChange(it.isFocused) }
                            .focusRequester(focusRequester)
                            .padding(top = 8.dp, bottom = 8.dp, start = 24.dp, end = 8.dp),
                        singleLine = true
                    )

                    when {
                        // todo loading -> LoadingIndicator
                        query.isNotEmpty() -> {
                            IconButton(onClick = onClearQuery) {
                                Icon(
                                    imageVector = Icons.Filled.Clear,
                                    contentDescription = "Clear the query"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}