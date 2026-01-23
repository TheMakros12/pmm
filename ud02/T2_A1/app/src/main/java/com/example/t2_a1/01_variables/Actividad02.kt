package com.example.t2_a1.`01_variables`

//      2. Definir tres variables inmutables y cargar por asignación los pesos de tres
//          personas con valores Float. Calcular el promedio de pesos de las personas
//          y mostrarlo. Mostrar también el promedio redondeado a 2 cifras.

fun main() {

    //Declaración de variables
    val peso1: Float = 86.6f
    val peso2: Float = 75.2f
    val peso3: Float = 93.4f

    //Procesamiento de los datos
    val pesoPromedio: Float = (peso1 + peso2 + peso3) / 3

    //Solución
    println("El peso promedio es: $pesoPromedio" + "Kg")
    println("El peso promedio redondeado es: %.2f".format(pesoPromedio) + "Kg")

}