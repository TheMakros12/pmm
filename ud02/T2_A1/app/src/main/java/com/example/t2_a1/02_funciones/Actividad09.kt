package com.example.t2_a1.`02_funciones`

import java.util.Scanner

//      9. Elaborar una función que reciba tres enteros y nos retorne el valor
//          promedio de los mismos. La impresión del promedio se realiza en el main.

//Esta función calcula el promedio de los datos que se le pasan como parámetros
fun promedio(num1: Int, num2: Int, num3: Int): Float {

    val promedio: Float = ((num1 + num2 + num3) / 3f)
    return promedio

}

fun main() {

    val entrada = Scanner(System.`in`)

    //Declaramos y inicializamos las variables
    println("Introduce el primer entero: ")
    val num1: Int = entrada.nextInt()
    println("Introduce el segundo entero: ")
    val num2: Int = entrada.nextInt()
    println("Introduce el tercer entero: ")
    val num3: Int = entrada.nextInt()

    //Se ejecuta la función y se guarda en una variable
    val promedio: Float = promedio(num1, num2, num3)

    //Solución
    print("El promedio de $num1, $num2 y $num3 es $promedio")

}