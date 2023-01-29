package com.github.clockworkclyde.whosedigits.ui.screens.bin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.clockworkclyde.whosedigits.models.ui.BinData
import com.github.clockworkclyde.whosedigits.ui.base.composables.search.SearchBar
import com.github.clockworkclyde.whosedigits.ui.screens.bin.composables.AboutBankSectionCard
import com.github.clockworkclyde.whosedigits.ui.screens.bin.composables.AboutCardSectionCard
import com.github.clockworkclyde.whosedigits.ui.screens.bin.composables.AboutCountrySectionCard

@Composable
fun SearchBinScreen(viewModel: SearchBinViewModel) {
    val result = viewModel.searchResult.collectAsState().value
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
        if (result != null) {
            SearchBinContent(data = result)
        }
    }
}


@Composable
fun SearchBinContent(data: BinData) {

    LazyColumn(
        modifier = Modifier
            .padding(all = 14.dp)
            .fillMaxWidth()
    ) {
        item {
            val bank = data.bank
            AboutBankSectionCard(
                name = "${bank.name}, ${bank.cityName}",
                websiteLink = bank.bankUrl,
                phone = bank.phoneNumber
            )
        }
        item {
            val country = data.country
            AboutCountrySectionCard(
                alpha2 = country.short,
                name = country.name,
                lat = country.lat,
                lng = country.lng
            )
        }
        item {
            AboutCardSectionCard(
                brand = data.brand,
                cardType = data.cardType,
                luhn = data.number.luhn,
                length = data.number.fullLength,
                scheme = data.scheme,
                isPrepaid = data.prepaid
            )
        }
    }
}