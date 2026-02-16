package com.example.t3a3_profe.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.t3a3_profe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTitle.text = "Bienvenido/a"

        binding.btnPosicionGlobal.setOnClickListener {
            Toast.makeText(this, "Funcionalidad no implementada", Toast.LENGTH_SHORT).show()
        }

        binding.btnMovimientos.setOnClickListener {
            Toast.makeText(this, "Funcionalidad no implementada", Toast.LENGTH_SHORT).show()
        }

        binding.btnTransferencias?.setOnClickListener {
            Toast.makeText(this, "Funcionalidad no implementada", Toast.LENGTH_SHORT).show()
        }

        binding.btnCambiarClave?.setOnClickListener {
            val intent = Intent(this, ChangePasswordActivity::class.java)
            startActivity(intent)
        }

        binding.btnPromociones?.setOnClickListener {
            Toast.makeText(this, "Funcionalidad no implementada", Toast.LENGTH_SHORT).show()
        }

        binding.btnCajeros?.setOnClickListener {
            Toast.makeText(this, "Funcionalidad no implementada", Toast.LENGTH_SHORT).show()
        }

        binding.btnSalir?.setOnClickListener {
            finish()
        }
    }
}
