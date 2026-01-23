package com.example.t2_a1.`03_infix`

//      12.Crea una función Infix llamada “esMayorQue” que tome dos números
//          como parámetros y devuelva true si el primero es mayor que el segundo,
//          de lo contrario, devuelve false. Puedes utilizarla para comparar dos
//          números.

//Está función se integra dentro de la clase Int y procesa si un número es mayor a otro
infix fun Int.esMayorQue(num: Int): Boolean {
    return this > num
}

fun main() {

    //Declaración e inicialización de las variables
    val a: Int = 7
    val b: Int = 15
    val c: Int = 5

    //Solución
    println("$a es mayor que $b? -> ${a esMayorQue b}")
    println("$a es mayor que $c? -> ${a esMayorQue c}")

}
