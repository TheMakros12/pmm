package com.example.ejemploroom

import android.app.Application
import androidx.room.Room
import com.example.ejemploroom.room.UserDatabase

class UserApplication: Application() {

    companion object {
        lateinit var database: UserDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, UserDatabase::class.java, "UserDatabase").build()
    }

}