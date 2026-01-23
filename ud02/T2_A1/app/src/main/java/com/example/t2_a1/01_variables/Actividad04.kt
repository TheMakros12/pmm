package com.example.t2_a1.`01_variables`

import java.util.Scanner

//      4. Se debe desarrollar un programa que pida el ingreso del precio de un
//          artículo y la cantidad que lleva el cliente. Mostrar lo que debe abonar el
//          comprador.

fun main() {

    val entrada = Scanner(System.`in`)

    //Declaración de variables.
    val precio: Float
    val cantidad: Int

    //Procesamiento de datos.
    println("Ingrese el precio del artículo: ")
    precio = entrada.nextFloat()
    println("Ingrese la cantidad del artículo: ")
    cantidad = entrada.nextInt()

    //Solución
    println("Debes abonar un total de: ${precio * cantidad}€")

}