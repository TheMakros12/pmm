package com.example.proyectosimagrow.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.proyectosimagrow.R
import com.example.proyectosimagrow.databinding.FragmentFormularioIncidenciaBinding

class FormularioIncidenciaFragment : Fragment() {

    private lateinit var binding: FragmentFormularioIncidenciaBinding

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

        binding.btnBorrar.setOnClickListener {
            limparCampos()
            Toast.makeText(requireContext(), "Se han borrado los datos!", Toast.LENGTH_SHORT).show()
        }

        binding.btnBorrar.setOnClickListener {
            if (validarFormulario()) {
                Toast.makeText(requireContext(), "Incidencia enviada correctamente!", Toast.LENGTH_SHORT).show()
            }
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
        } else if (titulo.length > 50) {
            binding.tiLayputTituloIncidencia.error = "Máximo 50 caracteres"
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

}