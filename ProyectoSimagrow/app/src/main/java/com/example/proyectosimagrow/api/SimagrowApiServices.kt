package com.example.proyectosimagrow.api

import com.example.proyectosimagrow.data.Espacio
import retrofit2.http.GET

interface SimagrowApiServices {

    @GET("/espacios")
    suspend fun getEspacios(): List<Espacio>

}