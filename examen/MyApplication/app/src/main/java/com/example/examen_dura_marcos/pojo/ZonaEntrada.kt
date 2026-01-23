package com.example.examen_dura_marcos.pojo

import java.io.Serializable

data class ZonaEntrada(val nombre: String, val precio: Double): Serializable {

    override fun toString(): String {
        return "$nombre: $precio€"
    }

    class Zonas {
        companion object {
            val zonas = arrayOf(
                ZonaEntrada("Pista General", 60.0),
                ZonaEntrada("Front Stage", 90.0),
                ZonaEntrada("Grada Alta", 40.0),
            )
        }
    }
}