package com.example.ejemploroom2.entities

import androidx.room.Embedded
import androidx.room.Relation

data class EquipoConJugadores(
    @Embedded
    val equipo: EquipoEntity,
    @Relation(parentColumn = "id", entityColumn = "equipoid")
    val jugadores: List<JugadorEntity>
    )
