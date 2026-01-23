package com.example.examen_dura_marcos.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen_dura_marcos.R
import com.example.examen_dura_marcos.adapters.OnClickListener
import com.example.examen_dura_marcos.databinding.ActivityMainBinding
import com.example.examen_dura_marcos.fragments.EventImageFragment
import com.example.examen_dura_marcos.fragments.EventListFragment
import com.example.examen_dura_marcos.pojo.Evento
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContenedorListadoEventos, EventListFragment())
                .replace(R.id.fragmentContenedorImagen, EventImageFragment())
                .commit()
        }

        binding.fabNewEvent.setOnClickListener {
            val intentNewEventActivity = Intent(this, NewEventActivity::class.java)
            startActivity(intentNewEventActivity)
        }

    }

    override fun onClick(evento: Evento) {
    }

}