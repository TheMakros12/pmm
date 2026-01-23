package com.example.toolbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.toolbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        setSupportActionBar(binding.toolBarInclude)

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottomHome -> {
                    binding.txtPantallaPrincipal.text = "Estas en Home"
                    true
                }
                R.id.bottomFavorites -> {
                    binding.txtPantallaPrincipal.text = "Estas en Favorites"
                    true
                }
                R.id.bottomProfile -> {
                    binding.txtPantallaPrincipal.text = "Estas en Settings"
                    true
                }
                else -> false
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menumain, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.actionBuscar -> {
                showToast("Pulsado Buscar")
                true
            }
            R.id.actionNuevo -> {
                showToast("Pulsado Nuevo")
                true
            }
            R.id.actionSettings -> {
                showToast("Pulsado Settings")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showToast(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

}