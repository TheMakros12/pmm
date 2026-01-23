package com.example.c_reto1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.c_reto1.databinding.ActivityLoginBinding

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

        Toast.makeText(this, "Bienvenid@ a Spotify", Toast.LENGTH_SHORT).show()

        val normalUser = Usuario("mdura", "123456")
        val adminUser = Usuario("admin", "000000")

        binding.btnLogin.setOnClickListener {
            val txtUser: String? = binding.etUser.text.toString()
            val txtPass: String? = binding.etPasswd.text.toString()

            if (txtUser.equals(normalUser.user) && txtPass.equals(normalUser.passwd)) {
                val intentUser = Intent(this, UserActivity::class.java)
                startActivity(intentUser)
            } else if (txtUser.equals(adminUser.user) && txtPass.equals(adminUser.passwd)) {
                val intentAdmin = Intent(this, AdminActivity::class.java)
                startActivity(intentAdmin)
            } else {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
                binding.etUser.setText("")
                binding.etPasswd.setText("")
            }
        }

    }

}