package com.example.uptodo.screen.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold {
        val padding = it
        Column {
            Text(text = "Hello this is HomeScreen")
        }
    }

}