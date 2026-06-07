package com.example.firstapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "quotes_table")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @SerializedName(value = "hadith_text")
    val text: String?,

    @SerializedName(value = "narrator")
    val author: String?,

    val isFavorite: Boolean = false
)