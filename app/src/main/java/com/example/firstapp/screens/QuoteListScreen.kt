package com.example.firstapp.screens

import com.example.firstapp.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.firstapp.model.Quote

import androidx.compose.foundation.layout.statusBarsPadding

@Composable
fun QuoteListScreen(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    Column(modifier = Modifier.statusBarsPadding()) {
        val montserrat = FontFamily(Font(R.font.montserrat_regular))
        Text(
            text = "Quote App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 16.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.headlineMedium, // Headline ব্যবহার করলে সুন্দর দেখায়
            fontFamily = montserrat,
            fontWeight = FontWeight.Bold
        )
        QuoteList(data = data, onClick)
    }
}