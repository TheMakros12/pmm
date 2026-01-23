package com.example.c_reto1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.c_reto1.databinding.ActivityAdminBinding

class AdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Toast.makeText(this, "Login Satisfactorio", Toast.LENGTH_LONG).show()

        binding.bnvUser.setOnItemSelectedListener {
            item ->
            when (item.itemId) {
                R.id.menuAdminBuscar -> btnBuscar()
                R.id.menuAdminUsuario -> btnPerfil()
                R.id.menuAdminAddUsuario -> btnUsuarios()
            }
            true
        }


    }

    private fun btnBuscar() {
        binding.lottieAnimationSpotify.pauseAnimation()
        binding.lottieAnimationSpotify.visibility = View.GONE
        binding.lottieAnimationPerfiles.visibility = View.GONE
        binding.scrollViewUser.visibility = View.VISIBLE
    }

    private fun btnPerfil() {
        binding.lottieAnimationSpotify.pauseAnimation()
        binding.lottieAnimationSpotify.visibility = View.GONE
        binding.scrollViewUser.visibility = View.GONE
        binding.lottieAnimationPerfiles.visibility = View.VISIBLE
        binding.lottieAnimationPerfiles.playAnimation()
    }

    private fun btnUsuarios() {
        Toast.makeText(this, "Proximamente...", Toast.LENGTH_LONG).show()

    }

}