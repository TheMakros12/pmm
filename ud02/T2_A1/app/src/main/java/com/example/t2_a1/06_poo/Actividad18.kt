package com.example.t2_a1.`06_poo`

import android.R
import kotlin.apply

//      18. En este ejercicio, modelamos un sistema de manejo de tareas (to-do list) con
//          diferentes categorías de tareas y funcionalidades para agregar, modificar y listar
//          tareas.

enum class Prioridad {
    ALTA,
    MEDIA,
    BAJA
}

data class Tarea(var nombre: String, var descripcion: String, var prioridad:  Prioridad, var completada: Boolean = false)

    fun agregarTarea(lista: MutableList<Tarea>, tarea: Tarea) {
        lista.add(tarea)
        println("Tarea ${tarea.nombre} agredada")
    }

    fun modificarTarea(lista: MutableList<Tarea>, nombreTarea: String) {
        var tareaModificada = lista.find { it.nombre == nombreTarea }
        if (tareaModificada != null) {
            println("Introduce la descripción: ")
            val nuevaDescripción = readln().toString()
            tareaModificada.descripcion = nuevaDescripción

            println("Introduce la prioridad (BAJA, MEDIA, ALTA): ")
            val nuevaPrioridad = readln().uppercase()
            try {
                val prioridad = Prioridad.valueOf(nuevaPrioridad)
                tareaModificada.prioridad = prioridad
            } catch (e: IllegalArgumentException) {
                println("Prioridad inválida. No se ha modificado.")
            }

            println("Introduce si se ha completado ('true' o 'false'): ")
            val nuevaCompletada = readln()
            if (nuevaCompletada == "true") {
                tareaModificada.completada = true
            } else {
                tareaModificada.completada = false
            }

            println("Tarea ${tareaModificada.nombre} modificada")
        } else {
            println("No se ha encontrado la tarea.")
        }
    }

    fun listarPorPrioridad(lista: MutableList<Tarea>, prioridad: Prioridad): List<Tarea> {
        return lista.filter { it.prioridad == prioridad }
    }

fun main() {

    var listaTareas = mutableListOf<Tarea>()

    listaTareas.apply {
        add(Tarea("Estudiar C++", "Repasar lo dado en clase o Nacho se enfada", Prioridad.ALTA))
        add(Tarea("Actividades Android", "Hacer las actividades del Tema 2", Prioridad.MEDIA))
        add(Tarea("Instalar Odoo", "Instalar Odoo en casa para poder trabajar lo dado en clase", Prioridad.BAJA))
    }

    with(listaTareas) {
        agregarTarea(this, Tarea("Proyecto Intermodular", "Realizar las actividades del Reto1 de Proyecto Intermodular",
            Prioridad.ALTA))

        modificarTarea(this, "Instalar Odoo")

        val prioridadAlta = listarPorPrioridad(this, Prioridad.ALTA)
        for (tarea in prioridadAlta) {
            println(tarea)
        }
    }

}