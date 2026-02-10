package com.example.ejemplo_api_videojuegos

data class GamesResponse(
    val results: List<Game>
)

data class Game(
    val id: Int,
    val name: String,
    val released: String,
    val background_image: String
)
