package com.example.t2_a1.`04_arrays`

import java.util.Scanner

//      14.Realizar un programa que pida la carga de dos arreglos numéricos enteros
//          de 4 elementos. Obtener la suma de los dos arreglos elemento a elemento,
//          dicho resultado guardarlo en un tercer arreglo del mismo tamaño.

fun main() {

    val entrada = Scanner(System.`in`)

    //Declaramos e inicializamos los array
    val arreglo1 = IntArray(4)
    val arreglo2 = IntArray(4)
    val arreglo3 = IntArray(4)

    //Cargamos el primer array con un bucle
    println("Vamos a cargar el primer array: ")
    for (i in arreglo1.indices) {
        println("[${i + 1}] Introduce un número: ")
        arreglo1[i] = entrada.nextInt()
    }

    //Cargamos el segundo array con un bucle
    println("Vamos a cargar el segundo array: ")
    for (i in arreglo1.indices) {
        println("[${i + 1}] Introduce un número: ")
        arreglo2[i] = entrada.nextInt()
    }

    //Sumamos el primer y segundo array, número a número, en el tercer array
    for (i in arreglo1.indices) {
        arreglo3[i] = arreglo1[i] + arreglo2[i]
    }

    //Solución
    println("El primer arreglo ${arreglo1.toList()}")
    println("El primer arreglo ${arreglo2.toList()}")
    println("La suma de los dos ${arreglo3.toList()}")

}