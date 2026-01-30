package com.example.t9_a2_dura_marcos.data

import androidx.room.Embedded
import androidx.room.Relation

data class ViajeConDestino(
    @Embedded
    val viaje: Viaje,
    @Relation(parentColumn = "id", entityColumn = "destinoid")
    val destino: Destino
)