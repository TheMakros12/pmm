package com.example.t2_a1.`04_arrays`

import java.util.Scanner

//      15.Desarrollar un programa que permita ingresar un arreglo de n elementos,
//          ingresar n por teclado. Elaborar dos funciones, una donde se cree y cargue
//          el array y otra que sume todos sus elementos y retorne dicho valor al main
//          donde se imprima.

//En esta función se crea y carga el array del tamaño que pasamos como parámetro
fun crearArray(num: Int): IntArray {

    val arreglo = IntArray(num)
    for (i in arreglo.indices) {
        println("[${i + 1}] Introduce un valor: ")
        arreglo[i] = entrada.nextInt()
    }
    return arreglo
}

//En esta función sumamos los números del arreglo en una variable
fun sumarArreglo(arreglo: IntArray): Int {

    var sumaTotal: Int = 0
    for (i in arreglo.indices) {
        sumaTotal += arreglo[i]
    }
    return sumaTotal

}

val entrada = Scanner(System.`in`)

fun main() {

    //Declaramos las variables
    var n: Int = 0
    var array: IntArray
    var sumaArray: Int = 0

    //Pedimos el tamaño del array
    println("Introduce el tamaño del Array: ")
    n = entrada.nextInt()

    //Creamos el array
    array = crearArray(n)

    //Sumamos los números del array
    sumaArray = sumarArreglo(array)

    //Solución
    println(array.toList())
    println("La suma del array es $sumaArray")

}