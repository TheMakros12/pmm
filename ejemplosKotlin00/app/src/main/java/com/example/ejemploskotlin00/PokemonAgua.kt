package com.example.ejemploskotlin00

class PokemonAgua(nombre: String,
                  ataque: Float,
                  salud: Float,
                  velocidad: Float,
                  var resistenciaAgia: Int,
                  var tiempoSumergido: Int): Pokemon(nombre, ataque, salud, velocidad) {

    fun respirar() {
        println("Glu Glu")
    }

    fun inmersion() {
        println("Chapuzón")
    }

}