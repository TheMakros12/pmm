package com.example.t2_a1.`02_funciones`

//      11.Confeccionar una función que reciba una serie de edades y nos retorne la
//          cantidad que son mayores o iguales a 18 (como mínimo se envía un entero
//          a la función). Utiliza vararg para implementarlo.

//En esta función se procesan las edades que se pasan como parámetros y retornamos cuantas son mayores o iguales a 18
fun mayorEdad(vararg edades: Int): Int {

    var mayorEdad: Int = 0
    for (edad in edades) {
        if (edad >= 18) {
            mayorEdad++;
        }
    }
    return mayorEdad

}

fun main() {

    //Declaramos dos ejemplos con diferentes edades
    val cantidad1: Int = mayorEdad(2, 19, 23, 8, 20)
    val cantidad2: Int = mayorEdad(7, 66, 34, 18, 82, 12, 2)

    //Solución
    println("El la primera lista hay $cantidad1 mayores o iguales a 18")
    println("El la segunda lista hay $cantidad2 mayores o iguales a 18")

}