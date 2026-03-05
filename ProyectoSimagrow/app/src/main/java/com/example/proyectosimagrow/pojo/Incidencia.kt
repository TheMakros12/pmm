package com.example.proyectosimagrow.pojo

data class Incidencia(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val estado: Boolean
) {
    companion object {
        val INCIDENCIAS = arrayOf(
            Incidencia(1, "Ventilador Estropeado", "Cuando el ventilador está funcionando a velocidad 3 vibra mucho y hace ruido", false),
            Incidencia(2, "Pérdida de agua", "La cisterna de uno de los inodoros pierde agua", false),
            Incidencia(3, "Error de calefacción", "Los radiadores de la clase están encendidos cuando no debería hacer falta", false),
            Incidencia(4, "Falta de papel", "La mayoría de los días no hay papel en el baño, ni para los inodoros ni para secarse las manos", false),
        )
    }
}
