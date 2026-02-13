package com.example.reto05_dragon_ball.data

data class CharactersResponse(
    val items: List<Character>
)

data class Character(
    val name: String,
    val race: String,
    val description: String,
    val image: String,
)