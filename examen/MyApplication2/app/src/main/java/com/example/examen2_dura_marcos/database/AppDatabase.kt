package com.example.examen2_dura_marcos.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.examen2_dura_marcos.api.Episode
import com.example.examen2_dura_marcos.dao.EpisodeDao

@Database(entities = [Episode::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao

}