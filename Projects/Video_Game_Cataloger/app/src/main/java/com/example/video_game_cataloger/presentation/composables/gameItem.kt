package com.example.video_game_cataloger.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.video_game_cataloger.R
import com.example.video_game_cataloger.presentation.data.gameDrawables
import com.example.video_game_cataloger.presentation.models.Game

@Composable
fun GameItem(game: Game) {
    var starred by remember { mutableStateOf(false) }
    val id = gameDrawables[extractGameName(game.imageUrl)] ?: R.drawable.gthe_elder_scrolls

    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(270.dp)
            .padding(8.dp)
            .clickable {
                // Handle the card click here if needed
            }
    ) {
        Box {
            Image(
                painter = painterResource(id = id),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(10.dp)
                    .background(Color.Black.copy(alpha = 0.5f), RoundedCornerShape(10.dp))
                    .padding(5.dp)
            ) {
                Text(
                    text = if (game.title.length > 15) "${game.title.substring(0, 15)}..." else game.title,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            IconButton(
                onClick = {
                    starred = !starred
                },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = if (starred) Icons.Filled.Star else Icons.Outlined.Star,
                    contentDescription = null,
                    tint = Color.Yellow,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}

@Composable
@Preview
fun GameItemPreview() {
    GameItem(
        game = Game(
            id = null,
            title = "Valorant",
            description = "Join a team of agents and engage in tactical battles using unique abilities and weapons.",
            genre = "RPG",
            platform = "PC",
            publisher = "Riot Games",
            releaseDate = "2020-06-02",
            imageUrl = "assets/images/games/valorant.jpg"
        )
    )
}

fun extractGameName(filePath: String): String {
    val fileNameWithExtension = filePath.substringAfterLast('/')
    val fileNameWithoutExtension = fileNameWithExtension.substringBeforeLast('.')
    return 'g' + fileNameWithoutExtension.replace("-", "_")
}


