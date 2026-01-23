package com.example.t2_a1.`05_when`

import java.util.Scanner

//      16.Ingresar 10 valores enteros por teclado. Contar cuántos de dichos valores
//          ingresados fueron 0, y cuántos de valores diferentes a 0. Recuerda utilizar
//          la cláusula when.

fun main() {

    val entrada = Scanner(System.`in`)

    //Declaramos las variables
    var numCeros: Int = 0
    var distintoCero: Int = 0

    //Comprobamos los números mayores a 0 y contamos
    println("Introduce 10 enteros: ")
    for (i in 1..10) {
        println("Número $i: ")
        val numero = entrada.nextInt()

        when (numero) {
            0 -> numCeros++
            else -> distintoCero++
        }
    }

    //Solución
    println("El total de 0 es de $numCeros")
    println("El total de distintos de 0 es $distintoCero")

}