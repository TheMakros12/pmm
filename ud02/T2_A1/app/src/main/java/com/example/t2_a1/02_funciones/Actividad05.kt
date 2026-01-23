package com.example.t2_a1.`02_funciones`

//      5. Desarrollar un programa con dos funciones. La primera que solicite el
//          ingreso de un entero y muestre el cuadrado de dicho valor. La segunda
//          que solicite la carga de dos valores y muestre el producto de estos. Llamar
//          desde la main a ambas funciones.


//En esta función se solicita un número entero y se muestra su cuadrado.
fun cuadrado() {

    println("\nPRIMERA FUNCIÓN")
    println("Introduce un entero: ")
    val numero: Int = readln().toInt()
    println("El cuadrado de $numero es ${numero * numero}")

}

//En esta función se solicitan dos enteros y se muestra su producto.
fun producto() {

    println("\nSEGUNDA FUNCIÓN")
    println("Introduce el primer entero: ")
    val num1: Int = readln().toInt()
    println("Introduce el segundo entero: ")
    val num2: Int = readln().toInt()
    println("El producto de $num1 y $num2 es ${num1 * num2}")

}

fun main() {

    //Solución
    cuadrado()
    producto()

}