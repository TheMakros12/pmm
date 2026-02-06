package com.example.ejemplo_api_gatos

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {
            try {
                val razagatos = RetrofitInstance.api.getListadoRazas()
                razagatos.forEach {
                    Log.i("RazaGato", "Id: ${it.id}, " +
                            "Peso: {${it.weight.imperial}Libs} {${it.weight.metric}Kg} " +
                            "Nombre: ${it.name}, " +
                            "Temperamento: ${it.temperament}, " +
                            "Origen: ${it.origin}")
                }
            } catch (e: Exception) {
                Log.e("ERROR", "Error en la API", e)
            }
        }

    }

}