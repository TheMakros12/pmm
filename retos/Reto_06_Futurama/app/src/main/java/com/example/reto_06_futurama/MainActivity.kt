package com.example.reto_06_futurama

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.reto_06_futurama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var main: Personaje
    private lateinit var bender: Personaje
    private lateinit var fry: Personaje
    private lateinit var vacio: Personaje

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cargarPersonajes()

        val bundle = Bundle()
        bundle.putSerializable("personaje", vacio)
        val fragment = InfoFragment()
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()

        binding.btnBender.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("personaje", bender)
            val fragment = InfoFragment()
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }

        binding.btnFry.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("personaje", fry)
            val fragment = InfoFragment()
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }

        binding.fragmentContainer.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("personaje", main)
            val fragment = InfoFragment()
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }
    }

    private fun cargarPersonajes() {
        main = Personaje("Futurama", 0, "Futurama es una serie animada de ciencia ficción y comedia creada por MattGroening, el creador de los Simpsons.")
        bender = Personaje("Bender Bending Rodríguez", 0, "Es un robot fabricado en México diseñado para doblar vigas de acero. Bender es sarcástico, egoísta y con tendencias delictivas.")
        fry = Personaje("Philip J.Fry", 0, "Es un repartidor de pizza de finales del siglo XX que se congela accidentalmente y se despierta mil años después. Fry es ingenuo, despistado y algo torpe.")
        vacio = Personaje("", 0, "")
    }

}