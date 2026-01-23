package com.example.t7a1_dura_marcos.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.t7a1_dura_marcos.R
import com.example.t7a1_dura_marcos.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Toast.makeText(this, "Bienvenid@", Toast.LENGTH_SHORT).show()

        val txtUsuario = binding.tiUsuario.text

        binding.btnEntrar.setOnClickListener {
            val intentMain = Intent(this, MainActivity::class.java).
                putExtra("usuario", txtUsuario)
            startActivity(intentMain)
        }

        binding.btnSalir.setOnClickListener {
            finish()
        }

    }

}