package com.example.reto05_dragon_ball.api

import com.example.reto05_dragon_ball.data.CharactersResponse
import retrofit2.http.GET

interface DragonBallApiServices {

    @GET("characters")
    suspend fun getCharacters(): CharactersResponse

}