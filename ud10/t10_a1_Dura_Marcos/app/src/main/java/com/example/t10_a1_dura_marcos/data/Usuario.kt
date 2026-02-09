package com.example.t10_a1_dura_marcos.data

import java.io.Serializable

data class Usuario(
    val nombre: String,
    val apellidos: String,
    val email: String,
    val edad: Int
) : Serializable
