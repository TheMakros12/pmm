package com.example.examen_dura_marcos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examen_dura_marcos.R
import com.example.examen_dura_marcos.adapters.EventoAdapter
import com.example.examen_dura_marcos.adapters.OnClickListener
import com.example.examen_dura_marcos.databinding.FragmentEventListBinding
import com.example.examen_dura_marcos.pojo.Evento
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class EventListFragment : Fragment(), OnClickListener {

    private lateinit var binding: FragmentEventListBinding
    private lateinit var eventoAdapter: EventoAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventListBinding.inflate(inflater, container, false)

        eventoAdapter = EventoAdapter(Evento.listaEventos.EVENTOS, this)
        linearLayoutManager = LinearLayoutManager(context)
        binding.recyclerEventos.apply {
            adapter = eventoAdapter
            layoutManager = linearLayoutManager
        }
        return binding.root
    }

    override fun onClick(evento: Evento) {
        val mensaje = "Id: ${evento.id}\nTítulo: ${evento.titulo}\nCategoria: ${evento.categoria}"

        // Creamos el AlertDialog
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(evento.titulo)
            .setMessage(mensaje)
            .setIcon(R.drawable.sport_event)
            .setPositiveButton("Cerrar") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }


}