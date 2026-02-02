package com.example.t9_a2_dura_marcos.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IViajeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(viaje: Viaje): Long

    suspend fun delete(viaje: Viaje)

    @Query("SELECT * FROM viajes")
    suspend fun getAll(): List<Viaje>

    @Query("SELECT * FROM viajes WHERE idViaje = :id")
    suspend fun getById(id: Long): Viaje?

    @Query("SELECT COUNT(*) FROM destinos WHERE idDestino = :destinoId")
    suspend fun countViajesPorDestino(destinoId: Long): Int

}