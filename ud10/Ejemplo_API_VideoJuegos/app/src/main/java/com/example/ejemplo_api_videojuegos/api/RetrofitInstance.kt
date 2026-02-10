package com.example.ejemplo_api_videojuegos.api

import com.example.ejemplo_api_videojuegos.api.VideoJuegoApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://api.rawg.io/api/"

    private const val API_KEY =
        "945f6ef90c1945dcb135e0f6966b3c04"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("key ", API_KEY)
                .build()
            chain.proceed(request)
        }
        .build()

    val api: VideoJuegoApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VideoJuegoApiService::class.java)
    }

}