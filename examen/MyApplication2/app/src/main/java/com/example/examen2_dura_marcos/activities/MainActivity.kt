package com.example.examen2_dura_marcos.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.examen2_dura_marcos.R
import com.example.examen2_dura_marcos.databinding.ActivityMainBinding
import com.example.examen2_dura_marcos.fragments.CharactersFragment
import com.example.examen2_dura_marcos.fragments.EpisodesFragment
import com.example.examen2_dura_marcos.fragments.InfoFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            replaceFragment(CharactersFragment())
        }

        binding.bottomNavigationBar.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_personajes -> {
                    replaceFragment(CharactersFragment())
                    binding.fragmentContainer.post {
                        (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as? CharactersFragment)
                            ?.mostrarLista()
                    }
                    true
                }
                R.id.navigation_episodios -> {
                    replaceFragment(EpisodesFragment())
                    true
                }
                R.id.navigation_info -> {
                    replaceFragment(InfoFragment())
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