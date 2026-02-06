package com.example.reto_libreria.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.reto_libreria.data.Libro

@Dao
interface LibroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(libro: Libro): Long

    @Query("SELECT * FROM libros")
    suspend fun getAll(): List<Libro>

}