package com.example.ejemploroom2.dao

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.ejemploroom2.entities.EquipoConJugadores
import com.example.ejemploroom2.entities.EquipoEntity
import com.example.ejemploroom2.entities.JugadorEntity

interface EquipoDao {

    @Insert
    suspend fun insertarJugador(jugador: JugadorEntity)

    @Insert
    suspend fun insertarEquipo(e: EquipoEntity): Long

    @Transaction
    @Query("SELECT * FROM equipos WHERE id = :equipoId")
    suspend fun getEquipoConJugadores(equipoId: Int): EquipoConJugadores

}