package com.example.ejemploexamen.api

import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun  getCharacters(): CharactersResponse

}