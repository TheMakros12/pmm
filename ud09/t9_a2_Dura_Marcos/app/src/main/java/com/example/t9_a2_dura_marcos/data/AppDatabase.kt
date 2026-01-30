package com.example.t9_a2_dura_marcos.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Destino::class,
        Viaje::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun destinoDao(): IDestinoDAO
    abstract fun viajeDao(): IViajeDAO
    abstract fun viajeConDestinoDao(): IViajesConDestinoDAO

}