package com.example.restcountries.ui.screens.commons

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.restcountries.data.dto.CountryDTO




@Composable
fun CountryUIList(
    countryList: List<CountryDTO>,
    favoritos: List<String> = emptyList(),
    onClick: (String, Boolean) -> Unit,
    onBookmarkClick: (String) -> Unit,

    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(countryList) { country ->
            CountryUIItem(
                country = country,
                onClick = onClick,
                isBookmarked = favoritos.contains(country.cca3),
                onBookmarkClick = { onBookmarkClick(country.cca3)
                }
            )
        }
    }
}


