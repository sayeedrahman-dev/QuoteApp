package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firstapp.screens.QuoteDetail
import com.example.firstapp.screens.QuoteListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App(viewModel: QuoteViewModel = hiltViewModel()) {
    val quotesState by viewModel.quotes
    val isLoading by viewModel.isLoading

    val favoritesFromDataBase by viewModel.favoriteQuotes.collectAsState(initial = emptyList())

    if (isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    } else {
        Scaffold(
            bottomBar = {
                if (DataManager.currentPage.value != Pages.DETAIL) {
                    NavigationBar {
                        NavigationBarItem(
                            selected = DataManager.currentPage.value == Pages.LISTING,
                            onClick = { DataManager.currentPage.value = Pages.LISTING },
                            label = { Text("Home") },
                            icon = { Icon(Icons.Default.Home, contentDescription = null) })

                        NavigationBarItem(
                            selected = DataManager.currentPage.value == Pages.FAVORITES,
                            onClick = { DataManager.currentPage.value = Pages.FAVORITES },
                            label = { Text("Favorites") },
                            icon = { Icon(Icons.Default.Favorite, contentDescription = null) })
                    }
                }
            }) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                when (DataManager.currentPage.value) {
                    Pages.LISTING -> {
                        QuoteListScreen(
                            data = quotesState.toTypedArray(),
                            viewModel = viewModel
                        ) {
                            DataManager.switchPages(it)
                        }
                    }

                    Pages.FAVORITES -> {
                        QuoteListScreen(
                            data = favoritesFromDataBase.toTypedArray(),
                            viewModel = viewModel
                        ) {
                            DataManager.switchPages(it)
                        }
                    }

                    Pages.DETAIL -> {
                        BackHandler {
                            DataManager.switchPages(null)
                        }
                        DataManager.currentQuote?.let { QuoteDetail(quote = it) }
                    }
                }
            }
        }
    }
}

enum class Pages {
    LISTING, DETAIL, FAVORITES
}