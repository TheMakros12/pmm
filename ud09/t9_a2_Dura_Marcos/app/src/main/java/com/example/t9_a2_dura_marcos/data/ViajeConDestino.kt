package com.example.t9_a2_dura_marcos.data

import androidx.room.Embedded
import androidx.room.Relation

data class ViajeConDestino(
    @Embedded
    val destino: Destino,
    @Relation(parentColumn = "idDestino", entityColumn = "destinoId")
    val viajes: List<Viaje>
)