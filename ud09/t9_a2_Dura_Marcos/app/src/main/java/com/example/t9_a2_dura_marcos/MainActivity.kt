package com.example.t9_a2_dura_marcos

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.t9_a2_dura_marcos.databinding.ActivityMainBinding
import com.example.t9_a2_dura_marcos.ui.destinos.DestinosFragment
import com.example.t9_a2_dura_marcos.ui.viajes.ViajeFormFragment
import com.example.t9_a2_dura_marcos.ui.viajes.ViajesListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragementContainer, ViajesListFragment())
            .commit()

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_viajes -> {
                    replaceFragment(ViajesListFragment())
                    true
                }
                R.id.navigation_destinos -> {
                    replaceFragment(DestinosFragment())
                    true
                }
                else -> false
            }
        }

        binding.fabAnyadirViaje.setOnClickListener {
            val intentAnyadirViaje = Intent(this, ViajeFormFragment::class.java)
            startActivity(intentAnyadirViaje)
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragementContainer, fragment)
            .commit()
    }

}