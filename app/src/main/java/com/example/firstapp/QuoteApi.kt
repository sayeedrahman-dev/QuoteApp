package com.example.firstapp

import com.example.firstapp.model.Quote
import com.example.firstapp.model.QuoteResponse
import retrofit2.Response
import retrofit2.http.GET


interface QuoteApi {
    @GET("6a0de8936877513b27a4888f/latest")
    suspend fun getQuotes(): Response<QuoteResponse>
}
