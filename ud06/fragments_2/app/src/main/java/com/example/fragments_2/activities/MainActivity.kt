package com.example.fragments_2.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragments_2.R
import com.example.fragments_2.databinding.ActivityMainBinding
import com.example.fragments_2.fragments.BlueFragment
import com.example.fragments_2.fragments.GreenFragment
import com.example.fragments_2.fragments.RedFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUno.setOnClickListener {
            cargarFragment(RedFragment())
        }

        binding.btnDos.setOnClickListener {
            cargarFragment(BlueFragment())
        }

        binding.btnTres.setOnClickListener {
            cargarFragment(GreenFragment())
        }

    }

    private fun cargarFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerFragment,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}