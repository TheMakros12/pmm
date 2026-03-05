package com.example.proyectosimagrow.fragments

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectosimagrow.adapters.RecompensaAdapter
import com.example.proyectosimagrow.databinding.FragmentRecompensasBinding
import com.example.proyectosimagrow.pojo.Recompensa

class RecompensasFragment : Fragment() {

    private lateinit var binding: FragmentRecompensasBinding
    private lateinit var adapterFilamento: RecompensaAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val recompensas = arrayOf("Filamentos", "Snacks", "Merchandising")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecompensasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.spinnerRecompensas.setSelection(0)
        cargarSpinner()
        cargarRecyclerView(0)
    }

    private fun cargarSpinner() {
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, recompensas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerRecompensas.adapter = adapter
    }

    private fun cargarRecyclerView(position: Int) {
        val selected = recompensas[position]
        adapterFilamento = RecompensaAdapter(arrayOf())
        binding.recyclerViewFilamentos.adapter = adapterFilamento
        linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewFilamentos.layoutManager = linearLayoutManager
    }

}