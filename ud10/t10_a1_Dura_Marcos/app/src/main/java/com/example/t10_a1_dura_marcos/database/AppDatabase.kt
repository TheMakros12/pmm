package com.example.t10_a1_dura_marcos.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.t10_a1_dura_marcos.dao.LegoDao
import com.example.t10_a1_dura_marcos.data.LegoResponse

@Database(entities = [LegoResponse::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun legoDao(): LegoDao
}
