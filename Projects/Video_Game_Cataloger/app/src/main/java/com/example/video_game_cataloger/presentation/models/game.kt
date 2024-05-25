package com.example.video_game_cataloger.presentation.models

data class Game(
    val id: Int?,
    val title: String,
    val description: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val releaseDate: String,
    val imageUrl: String
) {
    companion object {
        fun fromJson(json: Map<String, Any?>): Game {
            return Game(
                id = (json["id"] as? Int),
                title = json["title"] as String,
                description = json["description"] as String,
                genre = json["genre"] as String,
                platform = json["platform"] as String,
                publisher = json["publisher"] as String,
                releaseDate = json["releaseDate"] as String,
                imageUrl = json["imageUrl"] as String
            )
        }
    }

    override fun toString(): String {
        return "Game(id=$id, title='$title', description='$description', genre='$genre', platform='$platform', publisher='$publisher', releaseDate='$releaseDate', imageUrl='$imageUrl')"
    }
}