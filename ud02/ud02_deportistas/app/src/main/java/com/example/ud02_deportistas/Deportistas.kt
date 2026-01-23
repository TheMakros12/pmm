package com.example.ud02_deportistas

open class Deportista(protected var nombre: String, protected var edad: Int, protected var altura: Float, protected var nacionalidad: String) {
}

class Futbolista(nombre: String, edad: Int, altura: Float, nacionalidad: String, var club: String, var dorsal: Int, var goles: Int): Deportista(nombre, edad, altura, nacionalidad) {
}

class Luchador(nombre: String, edad: Int, altura: Float, nacionalidad: String, var estilo: String, var victorias: Int, var derrotas: Int): Deportista(nombre, edad, altura, nacionalidad) {
}

fun main() {

    var lamine: Futbolista = Futbolista("Lamine Yamal", 17, 1.78f, "Español", "F.C. Barcelona", 19, 11)
    var topuria: Luchador = Luchador("Ilia Topuria", 27, 1.70f, "Española", "Boxeo", 15, 0)

    println(lamine)
    println(topuria)

}