package com.example.examen2_dura_marcos.api

import retrofit2.http.GET

interface SimpsonsApiServices {

    @GET("characters")
    suspend fun getCharacters() : CharactersResponse

    @GET("episodes")
    suspend fun getEpisodes() : EpisodesResponse

}