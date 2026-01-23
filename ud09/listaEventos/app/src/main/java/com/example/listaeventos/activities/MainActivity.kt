package com.example.listaeventos.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listaeventos.adapters.EventoAdapter
import com.example.listaeventos.databinding.ActivityMainBinding
import com.example.listaeventos.entities.Evento
import com.example.listaeventos.entities.EventoDatos
import com.example.listaeventos.activities.EventoApplication
import com.example.listaeventos.room.EventoDatabase

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

        eventoAdapter = EventoAdapter(mutableListOf()) { evento -> eliminarEvento(evento) }
        linearLayoutManager = LinearLayoutManager(this)
        itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = eventoAdapter
            addItemDecoration(itemDecoration)
        }

        cargarEventos()

        binding.btnGuardar.setOnClickListener {
            Thread {
                val titulo: String = binding.etTituloEvento.text.toString()
                val fecha: String = binding.etFechaEvento.text.toString()

                if (titulo.isNotEmpty()) {
                    val event = Evento(titulo = titulo, fecha = fecha)
                    EventoApplication.database.eventoDao().insert(event)
                    cargarEventos()
                    binding.etTituloEvento.text.clear()
                    binding.etFechaEvento.text.clear()

                    runOnUiThread {
                        Toast.makeText(this, "Evento añadido!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    runOnUiThread {
                        Toast.makeText(this, "El Evento debe tener un título", Toast.LENGTH_SHORT).show()
                    }
                }

            }.start()
        }

    }

    private fun cargarEventos() {
        Thread {
            val lista = EventoApplication.database.eventoDao().getAll()

            runOnUiThread {
                eventoAdapter.actualizarLista(lista)
            }

        }.start()
    }

    private fun eliminarEvento(evento: Evento) {
        Thread {
            EventoApplication.database.eventoDao().delete(evento)
            cargarEventos()

            runOnUiThread {
                Toast.makeText(this, "Has eliminado un Evento", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

}