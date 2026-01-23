package com.example.listaeventos.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.listaeventos.entities.Evento

@Dao
interface EventoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(evento: Evento)

    @Delete
    fun delete(evento: Evento)

    @Query("SELECT * FROM eventos ORDER BY id DESC")
    fun getAll(): List<Evento>

}