package com.example.firstapp.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.firstapp.ui.viewmodel.QuoteViewModel
import com.example.firstapp.model.Quote
import com.example.firstapp.ui.components.QuoteListItem

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