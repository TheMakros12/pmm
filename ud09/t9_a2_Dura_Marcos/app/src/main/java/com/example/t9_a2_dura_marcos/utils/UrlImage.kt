package com.example.t9_a2_dura_marcos.utils

fun generarUrlImagenDestino(nombre: String): String {
    val limpio = nombre
        .lowercase()
        .trim()
        .replace(" ", "-")

    return "https://source.unsplash.com/600x400/?$limpio"
}