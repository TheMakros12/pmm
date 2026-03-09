package com.example.proyectosimagrow.data

data class IncidenciaResponse(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val estado: Boolean
) {
    companion object {
        val INCIDENCIAResponses = mutableListOf(
            IncidenciaResponse(1, "Ventilador Estropeado", "Cuando el ventilador está funcionando a velocidad 3 vibra mucho y hace ruido", false),
            IncidenciaResponse(2, "Pérdida de agua", "La cisterna de uno de los inodoros pierde agua", false),
            IncidenciaResponse(3, "Error de calefacción", "Los radiadores de la clase están encendidos cuando no debería hacer falta", true),
            IncidenciaResponse(4, "Falta de papel", "La mayoría de los días no hay papel en el baño, ni para los inodoros ni para secarse las manos", true),
            IncidenciaResponse(5, "Ventilador Estropeado", "Cuando el ventilador está funcionando a velocidad 3 vibra mucho y hace ruido", false),
            IncidenciaResponse(6, "Pérdida de agua", "La cisterna de uno de los inodoros pierde agua", false),
            IncidenciaResponse(7, "Error de calefacción", "Los radiadores de la clase están encendidos cuando no debería hacer falta", true),
            IncidenciaResponse(8, "Falta de papel", "La mayoría de los días no hay papel en el baño, ni para los inodoros ni para secarse las manos", true),
        )
    }
}
