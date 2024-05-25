package com.example.video_game_cataloger.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutPage() {
    val aboutPageContent = """
        Welcome to Video Game Catalogue, the ultimate mobile companion for gaming enthusiasts! Developed using Flutter, our app is designed to enhance your gaming experience by providing intuitive game management and a community-driven review system.
        ^
        Features:
        ^
        Game Management:
        ^
        ✨ Easily explore and navigate through a diverse catalog of games.
        ✨ Add your favorite games to your collection for quick access.
        ✨ Enjoy a structured overview of your gaming interests.
        ✨ Flexibility to remove games from your favorites as your preferences evolve.
        ^
        Review System:
        ^
        ✨ Share your gaming experiences with the community.
        ✨ Provide detailed feedback and ratings for each game.
        ✨ Utilize a 5-star rating system to express your opinions.
        ✨ Explore reviews from other users to discover new games.
        ✨ Write, edit, or delete your own reviews as needed.
        ^
        Our Vision:
        ^
        At Video Game Catalogue, we envision a platform where gamers can seamlessly manage their gaming preferences and actively engage with a vibrant community. Whether you're a casual player or a hardcore gamer, our app is tailored to meet your needs and foster a sense of camaraderie among fellow gaming enthusiasts.
        ^
        Join Us:
        ^
        Download Video Game Catalogue now and embark on a journey to discover, organize, and review your favorite games like never before. Let's build a thriving gaming community together!
        ^
    """.trimIndent().split("^").map { it.trim() }

    Scaffold(
        containerColor = Color(0xFF455A64),
        topBar = {
            TopAppBar(
                title = { Text("About", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())  },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF263238),
                    titleContentColor = Color.White
                ),


            )
        },
        content = {
            AboutContent(aboutPageContent, Modifier
                .fillMaxSize()
                .padding(it)
                .padding(10.dp))
        }
    )
}

@Composable
fun AboutContent(content: List<String>, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF37474F)),
            modifier = Modifier.padding(16.dp)
        ) {
            SelectionContainer {
                LazyColumn(
                    modifier = Modifier.padding(16.dp)
                ) {
                    items(content) { text ->
                        if (text.isNotEmpty() && text[0].isLetter() && text[1] == ':') {
                            Text(
                                text = text,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.W200,
                                color = Color.White,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(bottom = 20.dp)
                            )
                        } else {
                            Text(
                                text = text,
                                fontSize = 18.sp,
                                color = Color.White,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(bottom = 20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutPagePreview() {
    AboutPage()
}