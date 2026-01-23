package com.example.ejemploskotlin00

abstract class Animal(var nombre: String) {

    fun respirar() {
        println("Estoy respirando")
    }

    //Métodos sin implementar
    abstract fun sonido()

}

class perro(nombre: String): Animal(nombre) {

    override fun sonido() {
        print("$nombre Miau miau")
    }
}

class gato(nombre: String): Animal(nombre) {

    override fun sonido() {
        println("$nombre Guau Guau")
    }
}

class pajaro(nombre: String): Animal(nombre) {

    override fun sonido() {
        println("$nombre Grr Grr")
    }
}

fun main() {

    val perrito: perro = perro("Tobby")
    perrito.respirar()
    perrito.sonido()

    val gatito: gato = gato("Misifu")
    gatito.respirar()
    gatito.sonido()

    val pajarito: pajaro = pajaro("Piolin")
    pajarito.respirar()
    pajarito.sonido()

}