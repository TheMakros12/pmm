package com.example.reto1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.reto1.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Toast.makeText(this, "Login satisfactorio", Toast.LENGTH_SHORT).show()

        binding.bottomNavViewUser.setOnItemSelectedListener {
            item ->
            when (item.itemId) {
                R.id.user_buscar -> btnBuscar()
                R.id.user_perfil -> btnPerfil()
            }
            true
        }

    }

    private fun btnBuscar() {
        binding.lottiePerfilUser.visibility = View.GONE
        binding.scrollView.visibility = View.VISIBLE
        binding.lottiePerfiles.visibility = View.GONE
    }

    private fun btnPerfil() {
        binding.lottiePerfilUser.visibility = View.GONE
        binding.scrollView.visibility = View.GONE
        binding.lottiePerfiles.visibility = View.VISIBLE
        binding.lottiePerfiles.playAnimation()
    }

}