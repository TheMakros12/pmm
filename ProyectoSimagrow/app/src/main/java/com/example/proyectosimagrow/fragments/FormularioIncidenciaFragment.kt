package com.example.proyectosimagrow.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.proyectosimagrow.R
import com.example.proyectosimagrow.api.RetrofitInstance
import com.example.proyectosimagrow.data.Espacio
import com.example.proyectosimagrow.data.EspaciosResponse
import com.example.proyectosimagrow.databinding.FragmentFormularioIncidenciaBinding
import kotlinx.coroutines.launch

class FormularioIncidenciaFragment : Fragment() {

    private lateinit var binding: FragmentFormularioIncidenciaBinding
    private val plantas = arrayOf("0", "1", "2")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormularioIncidenciaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        limparCampos()
        cargarSpinnerPlantas()

        binding.btnBorrar.setOnClickListener {
            limparCampos()
            Toast.makeText(requireContext(), "Se han borrado los datos!", Toast.LENGTH_SHORT).show()
        }

        binding.btnEnviar.setOnClickListener {
            if (validarFormulario()) {
                //Crear la incidencia y enviarla a la bd.
                Toast.makeText(requireContext(), "IncidenciaResponse enviada correctamente!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.spinnerPlantaEspacions.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    val plantaSeleccionada = plantas[position]
                    cargarSpinnerEspacios(plantaSeleccionada)
                }
                override fun onNothingSelected(parent: AdapterView<*>) {}
            }
    }

    private fun limparCampos() {
        binding.etNombreIncidencia.text?.clear()
        binding.spinnerEspacions.setSelection(0)
        binding.etDescripcionIncidencia.text?.clear()
    }

    private fun validarFormulario(): Boolean {

        val titulo = binding.etNombreIncidencia.text.toString().trim()
        val descripcion = binding.etDescripcionIncidencia.text.toString().trim()

        var esValido = true

        binding.tiLayputTituloIncidencia.error = null
        binding.tiLayputDescripcionIncidencia.error = null

        if (titulo.isEmpty()) {
            binding.tiLayputTituloIncidencia.error = "El título no puede estar vacío"
            esValido = false
        } else if (titulo.length > 30) {
            binding.tiLayputTituloIncidencia.error = "Máximo 30 caracteres"
            esValido = false
        }

        if (descripcion.isEmpty()) {
            binding.tiLayputDescripcionIncidencia.error = "La descripción no puede estar vacía"
            esValido = false
        } else if (descripcion.length > 250) {
            binding.tiLayputDescripcionIncidencia.error = "Máximo 250 caracteres"
            esValido = false
        }

        return esValido
    }

    private fun cargarSpinnerPlantas() {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, plantas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPlantaEspacions.adapter = adapter
    }

    private fun cargarSpinnerEspacios(planta: String) {

        lifecycleScope.launch {
            //Recoger los espacios de las base de datos.
            val listaEspacios = RetrofitInstance.api.getEspacios()

            val espacios = when (planta) {
                "0" -> listaEspacios.filter { it.planta == 0 }
                "1" -> listaEspacios.filter { it.planta == 1 }
                "2" -> listaEspacios.filter { it.planta == 2 }
                else -> emptyList()
            }

            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, espacios)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerEspacions.adapter = adapter
        }
    }

}