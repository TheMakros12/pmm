package com.example.ejemploroom2.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "jugadores",
    foreignKeys = [
        ForeignKey(
            entity = EquipoEntity::class,
            parentColumns = ["id"],
            childColumns = ["equipoid"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class JugadorEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre: String,
    val equipoId: Int
)
