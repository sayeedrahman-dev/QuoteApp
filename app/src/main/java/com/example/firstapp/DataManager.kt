package com.example.firstapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.firstapp.model.Quote
import com.google.gson.Gson

object  DataManager {
    var data = emptyArray<Quote>()
    val isDataLoaded = mutableStateOf(false)

    fun loadQuotesFromAssets(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }
}