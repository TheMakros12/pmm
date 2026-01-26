package com.example.t9_a2_dura_marcos.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "destinos")
data class Destino(
    @PrimaryKey(autoGenerate = true)
    val idDestino: Int,
    val nombre: String,
    val pais: String
)
