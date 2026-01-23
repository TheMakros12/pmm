package com.example.t2_a1.`02_funciones`

//      10.Hacer una función que reciba una cantidad variable de enteros y retorne
//          su suma. Utiliza vararg para implementarlo.

//En está función se suman los números que se pasan como parámetros mediante un "vararg"
fun sumaVariable(vararg numeros: Int): Int {

    var sumaTotal: Int = 0
    for (numero in numeros) {
        sumaTotal += numero
    }
    return sumaTotal

}

fun main() {

    //Declaramos dos ejemplos con diferente cantidad de números
    val suma1: Int = sumaVariable(2, 5, 9, 10)
    val suma2: Int = sumaVariable(12, 33, 8, 95, 21, 9, 45)

    //Solución
    println("La suma de [2, 5, 9, 10] es $suma1")
    println("La suma de [12, 33, 8, 95, 21, 9, 45] es $suma2")

}