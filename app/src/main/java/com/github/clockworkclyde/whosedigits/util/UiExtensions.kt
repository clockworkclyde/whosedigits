package com.github.clockworkclyde.whosedigits.util

import android.content.Context
import android.content.Intent
import android.net.Uri
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

fun Context.goToMapActivityWithParams(lat: Float, lng: Float) {
   val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:$lat,$lng"))
   startActivity(intent)
}