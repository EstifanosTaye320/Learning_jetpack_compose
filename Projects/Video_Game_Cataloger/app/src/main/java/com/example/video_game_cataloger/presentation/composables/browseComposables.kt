package com.example.video_game_cataloger.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import com.example.video_game_cataloger.presentation.models.Game


@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(color = Color(0xFF455A64))
    }
}

@Composable
fun ErrorScreen(error: String, modifier: Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Error: $error", color = Color.White, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            IconButton(onClick = {  }) {
                Icon(Icons.Default.Refresh, contentDescription = "Retry", tint = Color.Blue)
            }
        }
    }
}

@Composable
fun GamesList(games: List<Game>, modifier: Modifier) {
    if (games.isEmpty()) {
        EmptyGamesScreen(modifier)
    } else {
        // Display games
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp), // Padding around the grid
            modifier = Modifier.fillMaxSize()
        ) {
            items(games) { game ->
                GameItem(game) // Padding between items
            }
        }
    }
}

@Composable
fun EmptyGamesScreen(modifier: Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.Notifications, contentDescription = null, tint = Color.Gray.copy(alpha = 0.5f), modifier = Modifier.size(100.dp))
            Spacer(modifier = Modifier.height(20.dp))
            Text("No game found", color = Color.Gray.copy(alpha = 0.5f), fontSize = 24.sp)
        }
    }
}
