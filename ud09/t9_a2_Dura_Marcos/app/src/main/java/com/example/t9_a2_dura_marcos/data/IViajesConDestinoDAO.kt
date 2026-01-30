package com.example.t9_a2_dura_marcos.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface IViajesConDestinoDAO {

    @Transaction
    @Query("SELECT * FROM destinos")
    suspend fun getDestinosConViajes(): List<ViajeConDestino>

}