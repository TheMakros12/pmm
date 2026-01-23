package com.example.t2_a1.`02_funciones`

//      7. En la función main solicitar que se ingrese una clave dos veces por teclado.
//          Desarrollar una función que reciba dos String como parámetros y muestre
//          un mensaje si las dos claves ingresadas son iguales o distintas.

//En esta función se comprueba si las dos cadenas son iguales
fun sonIguales(cadena1: String, cadena2: String) {

    if (cadena1 == cadena2) {
        println("Las cadenas son iguales.")
    } else {
        println("Las cadenas no son iguales.")
    }

}

fun main() {

    //Declaramos y inicializamos las dos variables
    println("Introduce la primera clave:")
    val cadena1: String = readln()
    println("Introduce la segunda clave:")
    val cadena2: String = readln()

    //Solucion
    sonIguales(cadena1, cadena2)

}