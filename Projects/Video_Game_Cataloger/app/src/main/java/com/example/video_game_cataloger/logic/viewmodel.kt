package com.example.video_game_cataloger.logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.video_game_cataloger.presentation.data.games
import com.example.video_game_cataloger.presentation.models.Game
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


sealed class GamesState {
    object Loading : GamesState()
    data class Loaded(val games: List<Game>) : GamesState()
    data class Error(val error: String) : GamesState()
}

class GamesViewModel : ViewModel() {
    private val _state = MutableStateFlow<GamesState>(GamesState.Error("Error Message by Estif"))
    val state: StateFlow<GamesState> = _state

    fun loadGames() {
        viewModelScope.launch {
            // Load games from a repository
        }
    }

    fun addToFavorites(game: Game) {
        viewModelScope.launch {
            // Add game to favorites
        }
    }

    fun removeFromFavorites(game: Game) {
        viewModelScope.launch {
            // Remove game from favorites
        }
    }
}