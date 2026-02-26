package com.example.examen2_dura_marcos.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.examen2_dura_marcos.api.Episode

@Dao
interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(episodes: List<Episode>): Long

    @Query("SELECT * FROM episodes")
    suspend fun getAll() : List<Episode>

}