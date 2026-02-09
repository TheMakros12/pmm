package com.example.t10_a1_dura_marcos.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.t10_a1_dura_marcos.R
import com.example.t10_a1_dura_marcos.data.Usuario
import com.example.t10_a1_dura_marcos.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrarApp.setOnClickListener {
            val nombre = binding.tiNombre.text.toString()
            val apellidos = binding.tiApellidos.text.toString()
            val email = binding.tiEmail.text.toString()
            val edadText = binding.tiEdad.text.toString()

            if (nombre.isEmpty() || apellidos.isEmpty() || email.isEmpty() || edadText.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val edad = try {
                edadText.toInt()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Edad no válida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuario = Usuario(nombre, apellidos, email, edad)

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("usuario", usuario)
            startActivity(intent)
        }

        binding.btnSalirApp.setOnClickListener {
            finishAffinity()
        }

    }

}