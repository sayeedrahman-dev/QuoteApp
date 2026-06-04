package com.example.firstapp.model

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("hadith_text")
    val text: String?,

    @SerializedName("narrator")
    val author: String?
)