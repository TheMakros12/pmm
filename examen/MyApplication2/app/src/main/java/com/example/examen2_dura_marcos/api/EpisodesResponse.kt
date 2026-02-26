package com.example.examen2_dura_marcos.api

import androidx.room.Entity
import androidx.room.PrimaryKey

data class EpisodesResponse(
    val results: List<Episode>
)

@Entity(tableName = "episodes")
data class Episode(
    @PrimaryKey
    val id: Int,
    val name: String,
    val season: Int,
    val synopsis: String
)
