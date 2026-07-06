package com.example.firstapp.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.data.repository.QuoteRepository
import com.example.firstapp.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val repository: QuoteRepository
) : ViewModel() {

    private val _quotes = mutableStateOf<List<Quote>>(emptyList())
    val quotes: State<List<Quote>> = _quotes

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _isDarkMode = mutableStateOf(false)
    val isDarkMode: State<Boolean> = _isDarkMode

    fun toggleDarkMode() {
        _isDarkMode.value = !_isDarkMode.value
    }

    val favoriteQuotes: Flow<List<Quote>> = repository.getAllFavorites()

    init {
        fetchQuotes()
    }

    fun fetchQuotes() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val result = repository.getQuoteFromNetwork()
                if (result != null) {
                    _quotes.value = result
                }
                _isLoading.value = false
            } catch (e: Exception) {
                _isLoading.value = false
            }
        }
    }

    fun addToFavorite(quote: Quote) {
        viewModelScope.launch {
            repository.insertFavorite(quote.copy(isFavorite = true))
        }
    }

    fun removeFromFavorite(quote: Quote) {
        viewModelScope.launch {
            repository.deleteFavorite(quote)
        }
    }
}