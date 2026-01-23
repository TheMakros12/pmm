package com.example.t2_a1.`06_poo`

//      17.Supongamos que estás creando un sistema para administrar una biblioteca
//          de libros. Vamos a modelar esta situación utilizando POO:

open class Libro(var titulo: String, var autor: String, var anyoPublicacion: Int, var precio: Double) {

    override fun toString(): String {
        return "Libro(titulo='$titulo', autor='$autor', anyoPublicacion=$anyoPublicacion, precio=$precio)"
    }

    open fun calcularPrecioDescuento(): Double = precio * 0.90

}

class LibroDigital(titulo: String, autor: String, anyoPublicacion: Int, precio: Double, var formato: String): Libro(titulo, autor, anyoPublicacion, precio) {

    override fun toString(): String {
        return super.toString() + ", Formato: $formato"
    }

    override fun calcularPrecioDescuento(): Double {
        return precio * 0.8
    }

}

fun main () {

    val libro1 = Libro("El corresponsal", "David Gimenez", 2013, 15.99)
    val libro2 = Libro("El sutil arte de que (casi todo) te importe una mierda", "Mark Manson", 2016, 25.00)
    val libroDigital1 = LibroDigital("Iniciación a Android en Kotlin", "AristiDevs", 2018, 12.60, "PDF")
    val libroDigital2 = LibroDigital("Aprende C++ en un fin de semana", "Alfredo Moreno Muñoz ", 2022, 22.40, "EPUB")

    val lista = listOf(libro1, libro2, libroDigital1, libroDigital2)

    for (libro in lista) {
        println(libro.toString())
        println("Precio con descuento: ${libro.calcularPrecioDescuento()}€")
        println()
    }

}
