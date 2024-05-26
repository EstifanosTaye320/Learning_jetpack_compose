package com.example.video_game_cataloger.presentation.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.video_game_cataloger.logic.GamesState
import com.example.video_game_cataloger.logic.GamesViewModel
import com.example.video_game_cataloger.presentation.composables.ErrorScreen
import com.example.video_game_cataloger.presentation.composables.GamesList
import com.example.video_game_cataloger.presentation.composables.LoadingScreen


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BrowsePage(viewModel: GamesViewModel = GamesViewModel()) {
    val state = viewModel.state.collectAsState().value

    Column(modifier = Modifier.background(color = Color(0xFF607D8B))) {
        Row (modifier = Modifier.fillMaxWidth().padding(10.dp) ,horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Browse", fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold, letterSpacing = 0.5.sp)
            IconButton(onClick = {  },
                modifier = Modifier
                    .width(145.dp)
                    .height(35.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFF29B6F6), contentColor = Color.White)) {

                Row {
                    Icon(Icons.Default.Add, contentDescription = "New Game")
                    Text("New Game", fontSize = 16.sp)
                }
            }
        }
        when (state) {
            is GamesState.Loading -> LoadingScreen(Modifier.background(color = Color(0xFF607D8B)))
            is GamesState.Loaded -> GamesList(state.games, Modifier.background(color = Color(0xFF607D8B)))
            is GamesState.Error -> {
                ErrorScreen(state.error, Modifier.background(color = Color(0xFF607D8B)))
            }
        }
    }
}