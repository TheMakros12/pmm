package com.example.ejemploskotlin00

open class Persona (open var dni: String, open var nombre: String, open var edad: Int) {

    var estaActivo: Boolean = true

    fun cambiarEstado() {
        if (estaActivo) {
            estaActivo = false
        } else {
            estaActivo = true
        }
    }

    fun setDni(dni: String) {
        this.dni = dni
    }
    fun setNombre(nombre: String) {
        this.nombre = nombre
    }
    fun setEdad(edad: Int) {
        this.edad = edad
    }

    fun getDni(): String {
        return "${this.dni}"
    }

    fun getNombre(): String {
        return this.nombre
    }

    fun getEdad(): Int? {
        return this.edad
    }

}