package com.github.clockworkclyde.whosedigits.ui.util

import android.widget.SearchView

inline fun SearchView.doOnQueryTextChanged(crossinline listener: (String) -> Unit) {
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {

        override fun onQueryTextSubmit(query: String?): Boolean = true

        override fun onQueryTextChange(newText: String?): Boolean {
            return if (newText.isNullOrEmpty()) false
            else {
                listener(newText)
                true
            }
        }
    })
}