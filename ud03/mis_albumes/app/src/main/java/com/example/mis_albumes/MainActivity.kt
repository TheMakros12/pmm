package com.example.mis_albumes

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mis_albumes.databinding.ActivityMainBinding
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

        val albumes = listOf<Album>(
            (Album(1, "Todos Los Días Todo El Día", "Latin Mafia", 2024, 31.12)),
            (Album(2, "Buenas Noches", "Quevedo", 2024, 56.37)),
            (Album(3, "Me Muevo Con Dios", "Cruz Cafuné", 2023, 76.00)),
            (Album(4, "Sayonara", "Alvaro Díaz", 2024, 61.00)),
            (Album(5, "Data", "Tainy", 2023, 63.00)),
            (Album(6, "Yo Hago Lo Que Me De La Gana", "Bad Bunny", 2020, 65.00)),
            (Album(7, "Pórtate Bien", "mvrk", 2025, 46.44)),
            (Album(8, "Natukashii Yoru", "Saiko", 2025, 38.05))
        )

        var albumSeleccionado: Album

        binding.imgTodosLosDiasTodoElDia.setOnClickListener {
            albumSeleccionado = albumes[0]
            val albumSeleccionado = Gson().toJson(albumSeleccionado)
            val intent = Intent(this, InfoActivity::class.java).apply {
                putExtra("album", albumSeleccionado)
            }
            startActivity(intent)
        }

        binding.imgBuenasNoches.setOnClickListener {
            albumSeleccionado = albumes[1]
            val albumSeleccionado = Gson().toJson(albumSeleccionado)
            val intent = Intent(this, InfoActivity::class.java).apply {
                putExtra("album", albumSeleccionado)
            }
            startActivity(intent)
        }

        binding.imgMeMuevoConDios.setOnClickListener {
            albumSeleccionado = albumes[2]
            val albumSeleccionado = Gson().toJson(albumSeleccionado)
            val intent = Intent(this, InfoActivity::class.java).apply {
                putExtra("album", albumSeleccionado)
            }
            startActivity(intent)
        }

        binding.imgSayonara.setOnClickListener {
            albumSeleccionado = albumes[3]
            val albumSeleccionado = Gson().toJson(albumSeleccionado)
            val intent = Intent(this, InfoActivity::class.java).apply {
                putExtra("album", albumSeleccionado)
            }
            startActivity(intent)
        }

        binding.imgData.setOnClickListener {
            albumSeleccionado = albumes[4]
            val albumSeleccionado = Gson().toJson(albumSeleccionado)
            val intent = Intent(this, InfoActivity::class.java).apply {
                putExtra("album", albumSeleccionado)
            }
            startActivity(intent)
        }

        binding.imgYHLQMDLG.setOnClickListener {
            albumSeleccionado = albumes[5]
            val albumSeleccionado = Gson().toJson(albumSeleccionado)
            val intent = Intent(this, InfoActivity::class.java).apply {
                putExtra("album", albumSeleccionado)
            }
            startActivity(intent)
        }

        binding.imgPortateBien.setOnClickListener {
            albumSeleccionado = albumes[6]
            val albumSeleccionado = Gson().toJson(albumSeleccionado)
            val intent = Intent(this, InfoActivity::class.java).apply {
                putExtra("album", albumSeleccionado)
            }
            startActivity(intent)
        }

        binding.imgNatsukashiiYoru.setOnClickListener {
            albumSeleccionado = albumes[7]
            val albumSeleccionado = Gson().toJson(albumSeleccionado)
            val intent = Intent(this, InfoActivity::class.java).apply {
                putExtra("album", albumSeleccionado)
            }
            startActivity(intent)
        }

    }

}