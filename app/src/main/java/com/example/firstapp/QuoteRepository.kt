package com.example.firstapp

import com.example.firstapp.model.QuoteResponse
import com.example.firstapp.model.Quote
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteRepository @Inject constructor(
    private val quoteApi: QuoteApi
) {
    suspend fun getQuoteFromNetwork(): List<Quote>? {
        val response = quoteApi.getQuotes()
        return if (response.isSuccessful) {
            response.body()?.record
        } else {
            null
        }
    }
}