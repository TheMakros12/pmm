package com.example.reto6_dura_marcos.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "libros")
data class Libro(
    @PrimaryKey(autoGenerate = true)
    private val id: Int = 0,
    val nombre: String,
    val autor: String
)
