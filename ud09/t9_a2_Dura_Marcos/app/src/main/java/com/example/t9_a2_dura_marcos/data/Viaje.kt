package com.example.t9_a2_dura_marcos.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.util.TableInfo

@Entity(
    tableName = "viajes",
    foreignKeys = [
        ForeignKey(
            entity = Destino::class,
            parentColumns = "id",
            childColumns = "destinoid",
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Viaje(
    @PrimaryKey(autoGenerate = true)
    val idViaje: Int,
    val titulo: String,
    val tipo: String,
    val descripcion: String
)
