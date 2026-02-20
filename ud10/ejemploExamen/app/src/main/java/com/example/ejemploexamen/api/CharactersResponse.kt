package com.example.ejemploexamen.api

import androidx.room.Entity
import androidx.room.PrimaryKey

data class CharactersResponse(
    val results: List<Character>
)

@Entity(tableName = "characters")
data class Character(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String
)
