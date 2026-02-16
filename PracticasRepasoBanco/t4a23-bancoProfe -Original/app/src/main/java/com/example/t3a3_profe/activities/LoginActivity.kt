package com.example.t3a3_profe.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.t3a3_profe.R
import com.example.t3a3_profe.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Evento botón Entrar
        binding.btnEntrar.setOnClickListener {

            val user = binding.tietUser.text.toString()
            val pass = binding.tietPass.text.toString()

            if (user.isEmpty()) {
                binding.tietUser.error = getString(R.string.campo_required)
                return@setOnClickListener
            }

            if (pass.isEmpty()) {
                binding.tietPass.error = getString(R.string.campo_required)
                return@setOnClickListener
            }

            // Simulación de login (UD4 NO usa API)
            if (user == "admin" && pass == "1234") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.login_error),
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        // Evento botón Salir
        binding.btnSalir.setOnClickListener {
            finish()
        }
    }
}
