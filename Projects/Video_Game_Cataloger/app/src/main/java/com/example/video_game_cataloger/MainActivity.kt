package com.example.video_game_cataloger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.video_game_cataloger.logic.GamesViewModel
import com.example.video_game_cataloger.presentation.composables.GameItem
import com.example.video_game_cataloger.presentation.data.games
import com.example.video_game_cataloger.presentation.screens.BrowsePage
import com.example.video_game_cataloger.presentation.screens.sampledata.AboutPage
import com.example.video_game_cataloger.presentation.screens.sampledata.LoginPage
import com.example.video_game_cataloger.presentation.screens.sampledata.RegistrationPage

import com.example.video_game_cataloger.ui.theme.Video_Game_CatalogerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrowsePage(viewModel = GamesViewModel())
        }
    }
}