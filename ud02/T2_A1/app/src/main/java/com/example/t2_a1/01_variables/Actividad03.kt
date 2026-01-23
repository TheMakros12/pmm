package com.example.t2_a1.`01_variables`

import java.util.Scanner

//      3. Escribir un programa en el cual se ingresen cuatro números enteros,
//          calcular e informar la suma de los dos primeros y el producto del tercero
//          y el cuarto. Realizar los cálculos en el mismo print.

fun main() {

    val entrada = Scanner(System.`in`)

    //Declaración y procesamiento de las variables.
    println("Introduce el primer número entero: ")
    val num1: Int = entrada.nextInt()
    println("Introduce el segundo número entero: ")
    val num2: Int = entrada.nextInt()
    println("Introduce el tercer número entero: ")
    val num3: Int = entrada.nextInt()
    println("Introduce el cuarto número entero: ")
    val num4: Int = entrada.nextInt()

    //Solución
    println("la suma de los dos primeros numeros es ${num1 + num2} y el producto de los dos últimos es: ${num3 * num4}")

}