package com.example.reto_06_futurama

import android.graphics.drawable.Drawable
import java.io.Serializable

data class Personaje(
    val nombre: String,
    val imagen: Int,
    val descripcion: String
) : Serializable
