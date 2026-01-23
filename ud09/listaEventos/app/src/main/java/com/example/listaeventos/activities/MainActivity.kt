package com.example.listaeventos.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listaeventos.adapters.EventoAdapter
import com.example.listaeventos.databinding.ActivityMainBinding
import com.example.listaeventos.entities.Evento
import com.example.listaeventos.entities.EventoDatos

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var eventoAdapter: EventoAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        eventoAdapter = EventoAdapter(EventoDatos.EVENTOS)
        linearLayoutManager = LinearLayoutManager(this)
        itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = eventoAdapter
            addItemDecoration(itemDecoration)
        }

        binding.btnGuardar.setOnClickListener {
            val titulo: String = binding.etTituloEvento.text.toString()
            val fecha: String = binding.etFechaEvento.text.toString()
            val event = Evento(titulo = titulo, fecha = fecha)
        }

    }

}