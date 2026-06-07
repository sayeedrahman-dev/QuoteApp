package com.example.firstapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.firstapp.QuoteViewModel
import com.example.firstapp.model.Quote

@Composable
fun QuoteList(
    data: Array<Quote>,
    viewModel: QuoteViewModel,
    favorites: List<Quote>,
    onClick: (quote: Quote) -> Unit
) {
    LazyColumn {
        items(data) { quote ->
            val isFav = favorites.any { it.text == quote.text }

            QuoteListItem(
                quote = quote, viewModel = viewModel, isFavorite = isFav, onClick = onClick
            )
        }
    }
}