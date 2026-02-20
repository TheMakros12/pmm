package com.example.ejemploexamen.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ejemploexamen.api.Character

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Character>)

    @Query("SELECT * FROM characters")
    suspend fun getAll() : List<Character>

    @Query("DELETE FROM characters")
    suspend fun deleteAll()

}