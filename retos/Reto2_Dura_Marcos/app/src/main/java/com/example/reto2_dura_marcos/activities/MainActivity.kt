package com.example.reto2_dura_marcos.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.reto2_dura_marcos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgPicachu.setOnClickListener {
            val intentRecycler = Intent(this, RecylcerActivity::class.java)
                .putExtra("item", "pokemon")
            startActivity(intentRecycler)
        }

        binding.imgDragon.setOnClickListener {
            val intentRecycler = Intent(this, RecylcerActivity::class.java)
                .putExtra("item", "dragon")
            startActivity(intentRecycler)
        }

    }

}