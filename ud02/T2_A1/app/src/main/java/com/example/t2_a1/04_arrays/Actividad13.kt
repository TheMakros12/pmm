package com.example.t2_a1.`04_arrays`

import java.util.Scanner

//      13.Cargar un array de 10 elementos de tipo entero y verificar posteriormente
//          si el mismo está ordenado de menor a mayor.

fun main() {

    val entrada = Scanner(System.`in`)

    //Declaramos el array
    val numeros = IntArray(10)

    //Inicializamos el array mediante un bucle.
    for (i in numeros.indices) {
        println("[${i + 1}]Introduce un número: ")
        numeros[i] = entrada.nextInt()
    }

    //Comprobamos si está ordenado de menor a mayor
    if (numeros.toList() == numeros.sorted()) {
        println("El array está ordenado de menor a mayor")
    } else {
        println("El array no está ordenado de menor a mayor")
    }

}