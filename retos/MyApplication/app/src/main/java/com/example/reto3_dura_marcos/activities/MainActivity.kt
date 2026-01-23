package com.example.reto3_dura_marcos.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.reto3_dura_marcos.R
import com.example.reto3_dura_marcos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.madrid.setOnClickListener {
            val webMadrid = "https://es.wikipedia.org/wiki/Real_Madrid_Club_de_Fútbol"
            val intentWeb = Intent(this, SecondActivity::class.java)
                .putExtra("url", webMadrid)
            startActivity(intentWeb)
        }

        binding.barcelona.setOnClickListener {
            val webBarcelona = "https://www.fcbarcelona.es/es/"
            val intentWeb = Intent(this, SecondActivity::class.java)
                .putExtra("url", webBarcelona)
            startActivity(intentWeb)
        }

        binding.valencia.setOnClickListener {
            val webValencia = "https://www.valenciacf.com"
            val intentWeb = Intent(this, SecondActivity::class.java)
                .putExtra("url", webValencia)
            startActivity(intentWeb)
        }

        binding.atleti.setOnClickListener {
            val webAtleti = "https://www.atleticodemadrid.com"
            val intentWeb = Intent(this, SecondActivity::class.java)
                .putExtra("url", webAtleti)
            startActivity(intentWeb)
        }

    }

}