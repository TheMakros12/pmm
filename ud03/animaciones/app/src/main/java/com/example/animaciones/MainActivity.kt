package com.example.animaciones

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView
import com.example.animaciones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var animacion = binding.lottieView

        animacion.setOnClickListener {
            reproducirAnimacion(animacion)
        }

        binding.bottomNavigation.setOnItemSelectedListener {
            item ->
            when(item.itemId) {
                R.id.inicio -> Log.d("menu","Home")
                R.id.buscar -> Log.d("menu","Search")
                R.id.configurar -> Log.d("menu","Config")
            }
            true
        }

    }

    private fun reproducirAnimacion(animacion: LottieAnimationView) {
        animacion.setAnimation(R.raw.animacion1)
        animacion.playAnimation()
    }

}