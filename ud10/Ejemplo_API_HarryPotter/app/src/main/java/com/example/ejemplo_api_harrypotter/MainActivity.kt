package com.example.ejemplo_api_harrypotter

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.ejemplo_api_harrypotter.api.RetrofitInstance
import com.example.ejemplo_api_harrypotter.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCargarPersonaje.setOnClickListener {
            lifecycleScope.launch {
                val resultado = RetrofitInstance.api.getCharacters()
                val listaFiltrada = resultado.filter { it.image.isNotEmpty() }
                val personaje = listaFiltrada.random()
                Log.e("Image", "${personaje.image}")

                binding.tvNombrePersonaje.text = personaje.name
                binding.tvCasaPersonaje.text = personaje.house

                Picasso.get()
                    .load(personaje.image)
                    .into(binding.ivPersonaje)
            }
        }
    }
}