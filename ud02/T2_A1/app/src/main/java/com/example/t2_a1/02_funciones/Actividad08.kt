package com.example.t2_a1.`02_funciones`

import java.util.Scanner

//      8. Confeccionar una función que reciba tres enteros y los muestre ordenados
//          de menor a mayor. En la función main solicitar la carga de 3 enteros por
//          teclado y proceder a llamar a la primera función definida.

//En esta función ordenamos los tres valores que se pasan como parámetros
fun ordenar(num1: Int, num2: Int, num3: Int) {

    val numeros = listOf(num1, num2, num3)
    val ordenados = numeros.sorted()
    println("Los números ordenados son $ordenados")

}

fun main() {

    //Declaramos y inicializamos las variables
    println("Introduce el primer número: ")
    val num1 = readLine()?.toIntOrNull() ?: 0
    println("Introduce el segundo número: ")
    val num2 = readLine()?.toIntOrNull() ?: 0
    println("Introduce el tercer número: ")
    val num3 = readLine()?.toIntOrNull() ?: 0

    //Mostramos los números antes y después de ordenarlos
    println("Los números sin ordenar son $num1 $num2 $num3")
    ordenar(num1, num2, num3)

}
