package com.example.firstapp.data.repository

import com.example.firstapp.data.local.QuoteDao
import com.example.firstapp.data.remote.QuoteApi
import com.example.firstapp.model.Quote
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteRepository @Inject constructor(
    private val quoteApi: QuoteApi, private val quoteDao: QuoteDao
) {
    suspend fun getQuoteFromNetwork(): List<Quote>? {
        val response = quoteApi.getQuotes()
        return if (response.isSuccessful) {
            response.body()?.record
        } else {
            null
        }
    }

    suspend fun insertFavorite(quote: Quote) {
        quoteDao.insertQuote(quote)
    }

    suspend fun deleteFavorite(quote: Quote) {
        quoteDao.deleteQuote(quote)
    }

    fun getAllFavorites() = quoteDao.getAllQuotes()
}