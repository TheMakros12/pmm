package com.example.ejemplo_api_gatos

data class RazaGato(
    val weight: Weight,
    val id: String,
    val name: String,
    val temperament: String,
    val origin: String,
)

data class Weight (
    val imperial: String,
    val metric: String
)