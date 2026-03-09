package com.example.proyectosimagrow.data

data class EspaciosResponse(
    val espacios: List<Espacio>
)

data class Espacio(
    val id: Int,
    val planta: Int,
    val nombre: String
)
