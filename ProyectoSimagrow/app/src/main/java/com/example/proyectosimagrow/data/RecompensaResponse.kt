package com.example.proyectosimagrow.data

data class RecompensaResponse(
    val nombre: String,
    val precio: Int,
    val imagen: Byte = 0
)