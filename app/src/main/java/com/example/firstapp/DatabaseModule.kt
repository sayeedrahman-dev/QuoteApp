package com.example.firstapp

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.Contexts
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): QuoteDataBase {
        return Room.databaseBuilder(
            context, QuoteDataBase::class.java, "quote_database"
        ).build()
    }

    @Provides
    fun provideQuoteDao(dataBase: QuoteDataBase): QuoteDao {
        return dataBase.quoteDao()
    }
}