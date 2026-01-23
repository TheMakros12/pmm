package com.example.ejemploskotlin00

class Profesor (override var dni: String, override var nombre: String, override var edad: Int): Persona(dni, nombre, edad) {

    private var experienciaDocente: Int = 0

    fun getExperienciaDocente(): Int {
        return this.experienciaDocente
    }

    fun setExperienciaDocente(experiencia: Int) {
        this.experienciaDocente = experiencia
    }
}