package com.example.ejemplo_api_rick_morty.api

import com.example.ejemplo_api_rick_morty.data.CharactersResponse
import retrofit2.http.GET

interface RickYMortyApiServices {

    @GET("character")
    suspend fun  getCharacters(): CharactersResponse

}