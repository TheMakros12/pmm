package com.example.proyectosimagrow.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectosimagrow.databinding.ActivityLoginBinding
import com.example.proyectosimagrow.data.UserResponse
import com.google.gson.Gson

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val NIA = "10639258"
    private val NOMBRE = "Marcos Durá Blasco"
    private val PASSWORD = "dur020802"
    private val CORREO = "mardurbla@alu.edu.gva.es"
    private val TOKENS = "1230"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrarLogin.setOnClickListener {
            realizarLogin()
        }
    }

    private fun realizarLogin() {
        val nia = binding.etUser.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        if (!validarCampos(nia, password)) return

        if (nia != NIA || password != PASSWORD) {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            return
        }

        val userResponse = UserResponse(nia = NIA, nombre = NOMBRE, correo = CORREO, tokens = TOKENS, password = PASSWORD)
        login(userResponse)
    }

    private fun login(userResponse: UserResponse) {
        val usuarioLogin = Gson().toJson(userResponse)
        val intentMainActivity = Intent(this, MainActivity::class.java).apply {
            putExtra("user", usuarioLogin)
        }
        startActivity(intentMainActivity)
        finish()
    }

    private fun validarCampos(username: String, password: String): Boolean {
        binding.tilUser.error = null
        binding.tilPassword.error = null

        var esValido = true

        if (username.isEmpty()) {
            binding.tilUser.error = "El usuario es obligatorio"
            esValido = false
        }
        if (password.isEmpty()) {
            binding.tilPassword.error = "La contraseña es obligatoria"
            esValido = false
        }

        return esValido
    }

}