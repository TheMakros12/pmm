package com.example.examen2_dura_marcos.api

data class CharactersResponse(
    val results: List<Character>
)

data class Character(
    val id: Int,
    val name: String,
    val occupation: String,
    val status: String,
    val portrait_path: String
)
