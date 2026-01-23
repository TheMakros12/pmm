package com.example.tema03_app0

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tema03_app0.databinding.ActivityDetallePaequeBinding
import com.google.gson.Gson

class ActivityDetallePaeque : AppCompatActivity() {

    private lateinit var binding: ActivityDetallePaequeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityDetallePaequeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recibirParque = intent.getStringExtra("parque")
        var parque: Parque? = null

        if (recibirParque != null) {
            parque = Gson().fromJson(recibirParque, Parque::class.java)
        }

        binding.apply {
            binding.txtNombreParque.text = parque?.nombre.toString()
            binding.txtDescriptionParque.text = parque?.descripcion.toString()
        }

    }

}