package com.example.ejemplo_api_harrypotter.api

import com.example.ejemplo_api_harrypotter.data.Personaje
import retrofit2.http.GET

interface HarryPotterApiServices {

    @GET("characters")
    suspend fun getCharacters(): List<Personaje>

}