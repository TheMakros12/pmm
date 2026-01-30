package com.example.t9_a2_dura_marcos.data

import android.app.Application
import androidx.room.Room

class ViajeApplication: Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "AppDatabase").build()
    }

}