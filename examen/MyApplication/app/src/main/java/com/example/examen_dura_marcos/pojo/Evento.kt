package com.example.examen_dura_marcos.pojo

data class Evento(val id: Int, val titulo: String, val categoria: String, val imagen: Int) {

    class listaEventos {
        companion object {
            val EVENTOS = arrayListOf(
                Evento(1, "Final Eurobasket", "DEPORTIVO", 1),
                Evento(2, "Concierto ROSALÍA", "MUSICAL", 2),
                Evento(3, "Disney on Ice", "INFANTIL", 3),
                Evento(4, "Filarmónica de Berlín", "MUSICAL", 2),
                Evento(5, "Concierto Quevedo", "MUSICAL", 2),
            )
        }
    }

}
