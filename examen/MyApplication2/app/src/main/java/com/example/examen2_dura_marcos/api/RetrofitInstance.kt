package com.example.examen2_dura_marcos.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://thesimpsonsapi.com/api/"

    val api: SimpsonsApiServices by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SimpsonsApiServices::class.java)
    }

}