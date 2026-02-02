package com.example.t9_a2_dura_marcos.ui.destinos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t9_a2_dura_marcos.R
import com.example.t9_a2_dura_marcos.data.Destino
import com.example.t9_a2_dura_marcos.data.IDestinoDAO
import com.example.t9_a2_dura_marcos.data.ViajeApplication
import com.example.t9_a2_dura_marcos.databinding.FragmentDestinosBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DestinosFragment : Fragment(R.layout.fragment_destinos) {

    private lateinit var binding: FragmentDestinosBinding
    private lateinit var adapter: DestinosAdapter
    private lateinit var destinoDao: IDestinoDAO

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDestinosBinding.bind(view)
        destinoDao = ViajeApplication.database.destinoDao()

        setupRecyclerView()
        cargarDestinos()
        setupListeners()

    }

    private fun setupRecyclerView() {
        adapter = DestinosAdapter(mutableListOf()) { destino -> eliminarDestino(destino) }

        binding.recyclerViewDestinos.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@DestinosFragment.adapter
        }
    }

    private fun cargarDestinos() {
        lifecycleScope.launch {
            val destinos = withContext(Dispatchers.IO) {
                destinoDao.getAll()
            }
            adapter.actualizarDetinos(destinos)
        }
    }

    private fun setupListeners() {
        binding.btnAnyadirDestino.setOnClickListener {
            val nombre = binding.etDestino.text.toString().trim()

            if (nombre.isNotEmpty()) {
                insertarDestino(nombre)
                binding.etDestino.text.clear()
            }
        }
    }

    private fun insertarDestino(nombre: String) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                destinoDao.insert(Destino(nombre = nombre))
            }
            cargarDestinos()
        }
    }

    private fun eliminarDestino(destino: Destino) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                destinoDao.delete(destino)
            }
            cargarDestinos()
        }
    }


}