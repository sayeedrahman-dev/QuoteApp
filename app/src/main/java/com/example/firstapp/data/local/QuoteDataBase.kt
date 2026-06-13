package com.example.firstapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.firstapp.model.Quote

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDataBase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDao
}