package com.example.firstapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun BlogCatagory() {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Row() {
            Image(
                painterResource(R.drawable.profile2), "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
            )
            IteamDiscription()
        }
    }
}

@Composable
private fun IteamDiscription() {
    Column() {
        Text(
            text = "ADevVibe",
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Own Youtube Chanel",
            fontWeight = FontWeight.Thin,
            fontSize = 12.sp
        )
    }
}



