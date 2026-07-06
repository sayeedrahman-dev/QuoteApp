package com.example.firstapp

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firstapp.ui.screens.QuoteDetail
import com.example.firstapp.ui.screens.QuoteListScreen
import com.example.firstapp.ui.theme.FirstAppTheme
import com.example.firstapp.ui.viewmodel.QuoteViewModel
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(viewModel: QuoteViewModel = hiltViewModel()) {
    val quotesState by viewModel.quotes
    val isLoading by viewModel.isLoading
    val isDarkMode by viewModel.isDarkMode
    val favoritesFromDatabase by viewModel.favoriteQuotes.collectAsState(initial = emptyList())

    var showMenu by remember { mutableStateOf(false) }

    val favoritesFromDataBase by viewModel.favoriteQuotes.collectAsState(initial = emptyList())

    FirstAppTheme(darkTheme = isDarkMode) {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background

        ) {
            if (isLoading) {
                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            } else {
                Scaffold(topBar = {
                    TopAppBar(title = { Text("হিকমাহ") }, actions = {
                        IconButton(onClick = { showMenu = true }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                        DropdownMenu(
                            expanded = showMenu, onDismissRequest = { showMenu = false }

                        ) {
                            DropdownMenuItem(
                                text = { Text(if (isDarkMode) " Light Mode" else "Dark Mode") },
                                onClick = {
                                    viewModel.toggleDarkMode()
                                    showMenu = false
                                })
                            DropdownMenuItem(
                                text = { Text("Settings") },
                                onClick = { showMenu = false })
                            DropdownMenuItem(
                                text = { Text("About") },
                                onClick = { showMenu = false })
                        }
                    })
                }, bottomBar = {
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
                                icon = {
                                    Icon(
                                        Icons.Default.Favorite, contentDescription = null
                                    )
                                })
                        }
                    }
                }) { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)) {
                        when (DataManager.currentPage.value) {
                            Pages.LISTING -> {
                                QuoteListScreen(
                                    data = quotesState.toTypedArray(), viewModel = viewModel
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
    }
}

enum class Pages {
    LISTING, DETAIL, FAVORITES
}