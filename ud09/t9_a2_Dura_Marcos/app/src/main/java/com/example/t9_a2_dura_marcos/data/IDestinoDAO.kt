package com.example.t9_a2_dura_marcos.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IDestinoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(destino: Destino)

    @Query("SELECT * FROM destinos")
    suspend fun getAll(): List<Destino>



}