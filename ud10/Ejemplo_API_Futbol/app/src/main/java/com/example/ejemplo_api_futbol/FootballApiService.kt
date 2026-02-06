package com.example.ejemplo_api_futbol

import retrofit2.http.GET
import retrofit2.http.Headers

interface FootballApiService {

    @Headers("X-Auth-Token: ff58f46023874b708e95ce7b76be02db")
    @GET("competitions/PD/teams")
    suspend fun getTeams(): TeamResponse

}