package com.example.t9_a2_dura_marcos.ui.viajes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.t9_a2_dura_marcos.R
import com.example.t9_a2_dura_marcos.data.Destino
import com.example.t9_a2_dura_marcos.data.IDestinoDAO
import com.example.t9_a2_dura_marcos.data.IViajeDAO
import com.example.t9_a2_dura_marcos.data.Viaje
import com.example.t9_a2_dura_marcos.data.ViajeApplication
import com.example.t9_a2_dura_marcos.databinding.FragmentViajeFormBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViajeFormFragment : Fragment(R.layout.fragment_viaje_form) {

    private lateinit var binding: FragmentViajeFormBinding
    private lateinit var destinoDao: IDestinoDAO
    private lateinit var viajeDao: IViajeDAO

    private var listaDestinos: List<Destino> = emptyList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentViajeFormBinding.bind(view)

        destinoDao = ViajeApplication.database.destinoDao()
        viajeDao = ViajeApplication.database.viajeDao()

        cargarSpinnerDestinos()
        setupListeners()

    }

    private fun cargarSpinnerDestinos() {

        lifecycleScope.launch {
            listaDestinos = withContext(Dispatchers.IO) {
                destinoDao.getAll()
            }

            val nombresDestinos = listaDestinos.map { it.nombre }
            val spinnerAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                nombresDestinos
            )
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            binding.spinnerDestinos.adapter = spinnerAdapter
        }

    }

    private fun setupListeners() {

        binding.btnGuardarViaje.setOnClickListener {
            val titulo = binding.tiTituloViaje.text.toString().trim()
            val tipo = binding.tiTipoViaje.text.toString().trim()
            val descripcion = binding.tiDescripcionViaje.text.toString().trim()
            val fecha = binding.tiFechaViaje.text.toString().trim()
            val posicionSpinner = binding.spinnerDestinos.selectedItemPosition

            if (titulo.isEmpty() || tipo.isEmpty() || descripcion.isEmpty() || fecha.isEmpty() || posicionSpinner < 0) {
                Toast.makeText(requireContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val destino = listaDestinos[posicionSpinner]

            val viaje = Viaje(
                nombreViaje = titulo,
                tipo = tipo,
                descripcion = descripcion,
                fecha = fecha,
                destinoId = destino.idDestino
            )

            binding.tiTituloViaje.text?.clear()
            binding.tiTipoViaje.text?.clear()
            binding.tiDescripcionViaje.text?.clear()
            binding.tiFechaViaje.text?.clear()

            insertarViaje(viaje)
        }

    }

    private fun insertarViaje(viaje: Viaje) {

        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                viajeDao.insert(viaje)
            }
            Toast.makeText(requireContext(), "Viaje guardado", Toast.LENGTH_SHORT).show()
        }

    }

}