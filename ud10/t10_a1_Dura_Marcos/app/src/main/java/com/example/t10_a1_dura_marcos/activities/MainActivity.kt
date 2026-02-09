package com.example.t10_a1_dura_marcos.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.t10_a1_dura_marcos.R
import com.example.t10_a1_dura_marcos.databinding.ActivityMainBinding
import com.example.t10_a1_dura_marcos.fragments.BuscarLegosFragment
import com.example.t10_a1_dura_marcos.fragments.MisLegosFragment
import com.example.t10_a1_dura_marcos.fragments.PerfilFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                    replaceFragment(PerfilFragment())
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