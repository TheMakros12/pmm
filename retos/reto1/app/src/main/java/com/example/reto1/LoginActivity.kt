package com.example.reto1

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.reto1.databinding.ActivityLoginBinding

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

        Toast.makeText(this, "Bienvenid@ a Vinted", Toast.LENGTH_SHORT).show()

        val userNormal = Usuario("jperez", "898989")
        val userAdmin = Usuario("admin", "123456")

        binding.btnLogin.setOnClickListener {
            val nombre: String? = binding.edTxtUser.text.toString()
            val contrasenya: String? = binding.edTxtPassw.text.toString()

            if (nombre.equals(userNormal.nombre) && contrasenya.equals(userNormal.paaswd)) {
                val intentUser = Intent(this, UserActivity::class.java)
                startActivity(intentUser)
            } else if (nombre.equals(userAdmin.nombre) && contrasenya.equals(userAdmin.paaswd)) {
                val intentAdmin = Intent(this, AdminActivity::class.java)
                startActivity(intentAdmin)
            } else {
                Toast.makeText(this, "Datos Incorrectos!!!", Toast.LENGTH_LONG).show()
            }
        }

    }

}