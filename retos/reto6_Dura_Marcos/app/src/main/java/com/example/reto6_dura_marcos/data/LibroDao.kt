package com.example.reto6_dura_marcos.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LibroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(libro: Libro)

    @Query("SELECT * FROM libros")
    suspend fun getAll(): List<Libro>

}