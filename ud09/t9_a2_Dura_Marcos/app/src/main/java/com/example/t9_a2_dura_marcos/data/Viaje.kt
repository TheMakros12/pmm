package com.example.t9_a2_dura_marcos.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "viajes",
    foreignKeys = [
        ForeignKey(
            entity = Destino::class,
            parentColumns = ["idDestino"],
            childColumns = ["destinoId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("destinoId")]
)
data class Viaje(
    @PrimaryKey(autoGenerate = true)
    val idViaje: Int = 0,
    val nombreViaje: String,
    val tipo: String,
    val descripcion: String,
    val fecha: String,
    val destinoId: Int
)
