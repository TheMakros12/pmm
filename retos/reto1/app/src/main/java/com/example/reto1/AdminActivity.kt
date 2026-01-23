package com.example.reto1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.reto1.databinding.ActivityAdminBinding

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

        Toast.makeText(this, "Login satisfactorio", Toast.LENGTH_SHORT).show()

        binding.bottomNavViewAdmin.setOnItemSelectedListener {
            item ->
            when (item.itemId) {
                R.id.admin_buscar -> btnBuscar()
                R.id.admin_perfil -> btnPerfil()
                R.id.admin_users -> Toast.makeText(this, "Proximamente...", Toast.LENGTH_LONG).show()
            }
            true
        }

    }

    private fun btnBuscar() {
        binding.lottiePerfil.visibility = View.GONE
        binding.scrollView.visibility = View.VISIBLE
        binding.lottiePerfiles.visibility = View.GONE
    }

    private fun btnPerfil() {
        binding.lottiePerfil.visibility = View.GONE
        binding.scrollView.visibility = View.GONE
        binding.lottiePerfiles.visibility = View.VISIBLE
        binding.lottiePerfiles.playAnimation()
    }

}