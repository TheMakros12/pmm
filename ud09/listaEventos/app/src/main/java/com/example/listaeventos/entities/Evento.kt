package com.example.listaeventos.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "eventos")
data class Evento(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "titulo")
    val titulo: String,

    @ColumnInfo(name = "fecha")
    val fecha: String

)

class EventoDatos {
    companion object {
        val EVENTOS = arrayListOf(
            Evento(titulo = "Exámen Interfaces", fecha = "26/01/2026"),
            Evento(titulo = "Cita con el médico", fecha = "27/01/2026"),
            Evento(titulo = "Presentación de la Falla", fecha = "07/02/2026"),
            Evento(titulo = "Pràcticas", fecha = "23/03/2026")
        )
    }
}
