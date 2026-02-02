package com.example.t9_a2_dura_marcos.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IDestinoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(destino: Destino): Long

    @Delete
    suspend fun delete(destino: Destino)

    @Query("SELECT * FROM destinos")
    suspend fun getAll(): List<Destino>

    @Query("SELECT * FROM destinos WHERE idDestino = :id")
    suspend fun getById(id: Long): Destino?

}