package com.example.reto_libreria.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "libros")
data class Libro(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val autor: String
)
