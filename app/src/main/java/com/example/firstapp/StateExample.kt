package com.example.firstapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun NotificationScreen(){
    // স্টেটটি প্যারেন্টে রাখা হয়েছে যাতে দুটি ফাংশনই একই ডাটা শেয়ার করতে পারে
    val count = remember { mutableIntStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)

    ) {
        // NotificationCounter কে বর্তমান মান এবং মান বাড়ানোর জন্য একটি ল্যাম্বডা ফাংশন দেওয়া হয়েছে
        NotificationCounter(count.intValue) { count.intValue++ }
        
        // MassageBar কে শুধু বর্তমান মানটি দেখানো হয়েছে
        MassageBar(count.intValue)
    }
}

@Composable
fun NotificationCounter(count: Int, onIncrement: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You Have sent $count Notifications")
        Button(onClick = onIncrement) { // বাটন ক্লিক করলে প্যারেন্টের কাউন্ট বাড়বে
            Text(text = "Send Notification")
        }
    }
}

@Composable
fun MassageBar(count: Int) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Outlined.Email,
                contentDescription = "Email Icon",
                modifier = Modifier.padding(4.dp)
            )
            Text(text = "Messages sent so far: $count")
        }
    }
}
