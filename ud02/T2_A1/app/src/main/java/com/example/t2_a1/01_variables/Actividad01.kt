package com.example.t2_a1.`01_variables`

//  1. Definir una variable inmutable con el valor 50 que representa el lado de
//      un cuadrado, en otras dos variables inmutables almacenar la superficie y
//      el perímetro del cuadrado. Mostrar la superficie y el perímetro en la
//      Consola.

fun main(){

    //Declaración de las variables.
    val lado: Int = 50
    val superficie: Int = lado * lado
    val perimetro: Int = lado * 4

    //Solución
    println("La superfície del cuadrado es de $superficie u^2")
    println("El perímetro del cuadrado es de $perimetro u")

}