package com.example.proyectosimagrow.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectosimagrow.databinding.ActivityLoginBinding
import com.example.proyectosimagrow.pojo.User
import com.google.gson.Gson

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val USER = "10639258"
    private val PASSWORD = "dur020802"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrarLogin.setOnClickListener {
            if (validarLogin()) {
                val username = binding.etUser.text.toString().trim()
                val password = binding.etPassword.text.toString().trim()

                val user = User(username, password)
                login(user)
            }
        }

    }

    fun login(user: User) {
        val usuarioLogin = Gson().toJson(user)
        val intentMainActivity = Intent(this, MainActivity::class.java).apply {
            putExtra("user", usuarioLogin)
        }
        startActivity(intentMainActivity)
        finish()
    }

    private fun validarLogin(): Boolean {
        val username = binding.etUser.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

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

        if (!esValido) return false

        if (username != USER || password != PASSWORD) {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

}