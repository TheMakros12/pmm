package com.example.ejemplo_api_videojuegos

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.ejemplo_api_videojuegos.api.RetrofitInstance
import com.example.ejemplo_api_videojuegos.api.VideoJuegoApiService
import com.example.ejemplo_api_videojuegos.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBuscarJuego.setOnClickListener {
            val nombreJuego: String = binding.etBuscarJuego.text.toString()

            lifecycleScope.launch {
                try {
                    val juegos = RetrofitInstance.api.getGames(nombreJuego, pageSize = 1)

                    val juego = juegos.results.firstOrNull()
                    val nombre = juego?.name + " " + juego?.released?.split("-")[0]
                    binding.tvNombreDelJuego.text = nombre
                    Picasso.get()
                        .load(juego?.background_image)
                        .into(binding.ivJuego)
                } catch (e: Exception) {
                    Log.e("Error", "${e.message}")
                }
            }


        }
    }

}