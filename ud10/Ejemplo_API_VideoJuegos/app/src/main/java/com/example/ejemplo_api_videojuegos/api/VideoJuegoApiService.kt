package com.example.ejemplo_api_videojuegos.api

import com.example.ejemplo_api_videojuegos.GamesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoJuegoApiService {

    @GET("games")
    suspend fun getGames(
        @Query("search") query: String,
        @Query("page_size") pageSize: Int = 1
    ): GamesResponse

}