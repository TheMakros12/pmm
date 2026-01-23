package com.example.albumes

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.albumes.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val discos = listOf(
            Album(1, "La Última", "Aitana", 2022, 37.5),
            Album(2, "La Jauria", "Dani Fernandez", 2025, 41.3),
            Album(3, "Cosa Nuestra", "Rauw Alejandro", 2024, 54.1),
            Album(4, "Milagro", "Sebastián Yatra", 2025, 45.0)
        )

        var discoSeleccionado: Album

        binding.albumAitana.setOnClickListener {
            pasarDatos(discos[0])
        }

        binding.albumDaniFernandez.setOnClickListener {
            pasarDatos(discos[1])
        }

        binding.albumRauwAlejandro.setOnClickListener {
            pasarDatos(discos[2])
        }

        binding.albumSebastianYatra.setOnClickListener {
            pasarDatos(discos[3])
        }

    }

    fun pasarDatos(discoSeleccionado: Album) {
        val discoSeleccionado = Gson().toJson(discoSeleccionado)
        val intent = Intent(this, InfoActivity::class.java).apply {
            putExtra("discoSeleccionado", discoSeleccionado)
        }
        startActivity(intent)
    }

}