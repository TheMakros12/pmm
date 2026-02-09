package com.example.t10_a1_dura_marcos.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.t10_a1_dura_marcos.R
import com.example.t10_a1_dura_marcos.data.Usuario
import com.example.t10_a1_dura_marcos.databinding.ActivityMainBinding
import com.example.t10_a1_dura_marcos.fragments.BuscarLegosFragment
import com.example.t10_a1_dura_marcos.fragments.MisLegosFragment
import com.example.t10_a1_dura_marcos.fragments.PerfilFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuario = intent.getSerializableExtra("usuario") as? Usuario
            ?: Usuario("Desconocido", "", "", 0)

        Toast.makeText(this, "Bienvenido ${usuario.nombre}!!!", Toast.LENGTH_SHORT).show()

        replaceFragment(BuscarLegosFragment())

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_buscar -> {
                    replaceFragment(BuscarLegosFragment())
                    true
                }
                R.id.navigation_mis_legos -> {
                    replaceFragment(MisLegosFragment())
                    true
                }
                R.id.navigation_perfil -> {
                    replaceFragment(PerfilFragment.newInstance(usuario))
                    true
                }
                else -> false
            }
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

}