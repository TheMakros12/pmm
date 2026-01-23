package com.example.t2_a1.`02_funciones`

//      6. Desarrollar una función que solicite la carga de tres valores y muestre el
//          menor. Desde la función main del programa llamar 2 veces a dicha función
//          (sin utilizar una estructura repetitiva)

//En esta función se ingresan 3 enteros y se muestra el menor de ellos.
fun menorDeTres() {

    println("Introduce el primer número: ")
    val num1: Int = readln().toInt()
    println("Introduce el segundo número: ")
    val num2: Int = readln().toInt()
    println("Introduce el tercer número: ")
    val num3: Int = readln().toInt()

    val numMenor: Int = minOf(num1, num2, num3)

    println("El número menor es $numMenor")

}

fun main() {

    //Solución
    menorDeTres()
    menorDeTres()

}
