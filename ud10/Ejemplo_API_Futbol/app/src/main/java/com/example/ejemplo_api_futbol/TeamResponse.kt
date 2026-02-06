package com.example.ejemplo_api_futbol

data class TeamResponse(
    val count: Int,
    val teams: List<Team>
)

data class Team(
    val id: Int,
    val name: String,
    val shortName: String,
    val tla: String
)