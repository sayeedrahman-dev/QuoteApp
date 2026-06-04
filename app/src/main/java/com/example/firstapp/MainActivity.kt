package com.example.firstapp

import android.R.attr.label
import android.R.attr.onClick
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firstapp.DataManager.data
import com.example.firstapp.model.Quote
import com.example.firstapp.screens.QouteListIteam
import com.example.firstapp.screens.QuoteDetail
import com.example.firstapp.screens.QuoteListScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        CoroutineScope(Dispatchers.IO).launch {

        }

        setContent {
            App()
        }
    }
}

@Composable
fun App(viewModel: QuoteViewModel = hiltViewModel()) {
    val quotesState by viewModel.quotes
    val isLoading by viewModel.isLoading

    if (isLoading) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()
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
                        QuoteListScreen(data = quotesState.toTypedArray()) {
                            DataManager.switchPages(it)
                        }
                    }

                    Pages.FAVORITES -> {
                        QuoteListScreen(data = DataManager.favoriteQuotes.toTypedArray()) {
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