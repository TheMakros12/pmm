package com.example.proyectosimagrow.activities

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.proyectosimagrow.R
import com.example.proyectosimagrow.databinding.ActivityMainBinding
import com.example.proyectosimagrow.fragments.RecompensasFragment
import com.example.proyectosimagrow.fragments.IncidenciasFragment
import com.example.proyectosimagrow.fragments.NoticiasFragment
import com.example.proyectosimagrow.pojo.Recompensa
import com.example.proyectosimagrow.pojo.User
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userRecibido = intent.getStringExtra("user")
        var user: User? = null

        if (userRecibido != null) {
            user = Gson().fromJson(userRecibido, User::class.java)
        }

        binding.bottomNavView.selectedItemId = R.id.menuIncidencias
        replaceFragment(IncidenciasFragment())

        binding.bottomNavView.setOnItemSelectedListener {
            item ->
            when(item.itemId) {
                R.id.menuIncidencias -> replaceFragment(IncidenciasFragment())
                R.id.menuRecompensas -> replaceFragment(RecompensasFragment())
                R.id.menuPerfil -> replaceFragment(NoticiasFragment())
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

}