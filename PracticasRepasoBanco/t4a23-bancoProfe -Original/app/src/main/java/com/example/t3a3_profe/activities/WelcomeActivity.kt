package com.example.t3a3_profe.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t3a3_profe.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrarApp.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            //Creamos un intent para iniciar LoginActivity
            startActivity(intent)
        }
    }


}