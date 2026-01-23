package com.example.ejemploskotlin00

import kotlin.math.pow

fun main() {

    val numero: Int = 4 add(3)
    val numero2: Int = 5 add(33)

    val texto: String = "Hola" join "Mundo"

    val numero3: Int = 31

    val numero4:Float = 5f.elevado(3f)

    println(numero)
    println(numero2)
    println(texto)
    if(numero3 esDivisible 5){
        println("Es múltiplo")
    } else {
        println("No es  múltiplo")
    }
    println(numero4)

}

//Funciones infix

infix fun Int.add(num: Int): Int = this + num

infix fun String.join(cadena: String): String = "$this $cadena"

infix fun Int.esDivisible(numero: Int): Boolean = this % numero == 0

infix fun Float.elevado(numero: Float): Float = this.pow(numero)
