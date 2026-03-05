package com.example.proyectosimagrow.fragments

import android.os.Bundle
import android.text.Layout
import android.text.SpannableString
import android.text.style.AlignmentSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectosimagrow.adapters.IncidenciaAdapter
import com.example.proyectosimagrow.databinding.FragmentIncidenciasBinding
import com.example.proyectosimagrow.pojo.Incidencia

class IncidenciasFragment : Fragment() {

    private lateinit var binding: FragmentIncidenciasBinding
    private lateinit var incidenciaAdapter: IncidenciaAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var dividerDecoration: DividerItemDecoration
    private val estados = arrayOf("Todas", "Resueltas", "No resueltas")
    private val incidencias = emptyArray<Incidencia>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIncidenciasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cargarSpinner()
        cargarRecyclerView()

        if ( incidencias.isEmpty() ) {
            binding.tvDatosIncidencias.visibility = View.GONE
        }
    }

    private fun cargarSpinner() {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, estados)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerEstadosIncidencias.adapter = adapter
    }

    private fun cargarRecyclerView() {
        incidenciaAdapter = IncidenciaAdapter(Incidencia.INCIDENCIAS, onItemClick = {incidencia -> mostrarDetalleIncidencia(incidencia)})
        linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        dividerDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.recyclerViewIncidencias.apply {
            adapter = incidenciaAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(dividerDecoration)
        }
    }

    private fun mostrarDetalleIncidencia(incidencia: Incidencia) {
        val titulo = SpannableString("Detalle de la Incidencia")
        titulo.setSpan(AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, titulo.length, 0)

        val estadoTexto = if (incidencia.estado) "Resuelta" else "Pendiente"

        val mensaje = """
            Id Incidenida:
            ${incidencia.id}
            
            Título:
            ${incidencia.nombre}
            
            Descripción:
            ${incidencia.descripcion}
            
            Estado: $estadoTexto
        """.trimIndent()

        com.google.android.material.dialog.MaterialAlertDialogBuilder(requireContext())
            .setTitle(titulo)
            .setMessage(mensaje)
            .setPositiveButton("Eliminar") { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton("Salir") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

}
