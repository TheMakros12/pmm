package com.example.ejemploskotlin00

const val MONEDA = "EURO"
const val PI = 3.1415
const val RADIO = 32
val areaCirculo =  PI*RADIO*RADIO

fun main() {


    println("Hello World!")

    println(areaCirculo)

    //Variables en Kotlin.
    var fecha = "15/09/2025"

    fecha = "17/10/2025"

    println("La fecha es $fecha")

    var nombre1: String = "Joan"

    var numero: Int = 32000

    var sueldo: Float = 123.12f

    var aprobado: Boolean = true

    var sueldo2: Double = 43243.43

    var letra: Char = 'c'
    var letra2 = letra.code

    println("El codigo de la letra $letra es el código $letra2")

    var numero2 = 56
    var letraNum = numero2.toChar()

    println(letraNum)

    var ciudad: String? = "Valencia"
    val resultado = ciudad?.length ?: 0

    println("La cidudad es $resultado")

    var nombre: String = "Marcos"
    saludo(nombre)

    var sueldo3: Float = 2300.30f
    var incremento = 100
    println(sumaSueldo(sueldo3, incremento))

    var mes: Int = 3

    //When es el equivalente al Switch
    when(mes) {
        1 -> println("Enero")
        2,3,4 -> println("Febrero, Marzo, Abril")
        5 -> println("Enero")
        else -> println("Eres tonto")
    }

}

fun saludo(nombre: String) {
    println("Hola $nombre")
}

fun sumaSueldo(sueldo: Float, incremento: Int): Float {
    var suma: Float = sueldo + incremento
    return suma
}
