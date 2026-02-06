package com.example.ejemplo_api_futbol

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1. - Creación de la instancia de Retrofit

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.football-data.org/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //2. - Creación del servicio de la API
        val apiService = retrofit.create(FootballApiService::class.java)

        //3. - Hacemos la llamada a la API
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getTeams()
                response.teams.forEach {
                    Log.i("Equipo", "Id: ${it.id}, Nombre: ${it.name}, shortName: ${it.shortName}, TLA: ${it.tla}")
                }
            } catch (e: Exception) {
                Log.e("ERROR", "Error en la API", e)
            }
        }
    }

}