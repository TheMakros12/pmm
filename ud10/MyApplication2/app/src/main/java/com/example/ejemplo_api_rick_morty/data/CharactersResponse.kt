package com.example.ejemplo_api_rick_morty.data

data class CharactersResponse(
    val results: List<Character>
)

data class Character(
    val name: String,
    val status: String,
    val image: String
)
