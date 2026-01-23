package com.example.preferencias

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatCallback
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatViewInflater
import androidx.core.app.SharedElementCallback
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.preference.PreferenceManager
import com.example.preferencias.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("Mi preferencia", Context.MODE_PRIVATE)

        binding.btnGuardar.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString("email", binding.edCorreo.text.toString())
            editor.apply()
        }

        binding.btnRecuperar.setOnClickListener {
            val valorRecuperado = sharedPreferences.getString("email", "Sin valor")

            binding.tvEmailRecuperado.text = valorRecuperado
        }

        binding.btnPreferencias.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        binding.btnMostrarPreferencias.setOnClickListener {
            val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

            Log.i("Tema 08", "Reproducir Música " + sharedPreferences.getBoolean("musica", false))
            Log.i("Tema 08", "Nick " + sharedPreferences.getString("nick", "Sin nick"))
            Log.i("Tema 08", "País " + sharedPreferences.getString("pais", "Sin pais"))
        }

    }

    override fun onResume() {
        super.onResume()

        if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean("modooscuro", false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

    }

}