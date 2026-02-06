package com.example.ejemplo_api_gatos

import retrofit2.http.GET

interface CatApiService {

    @GET("breeds")
    suspend fun getListadoRazas(): List<RazaGato>

}