package com.example.t10_a1_dura_marcos.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.t10_a1_dura_marcos.R
import com.example.t10_a1_dura_marcos.data.Usuario
import com.example.t10_a1_dura_marcos.database.LegoApplication
import com.example.t10_a1_dura_marcos.databinding.FragmentPerfilBinding
import kotlinx.coroutines.launch

class PerfilFragment : Fragment() {

    private lateinit var binding: FragmentPerfilBinding
    private var usuario: Usuario? = null

    companion object {
        private const val ARG_USUARIO = "usuario"

        fun newInstance(usuario: Usuario): PerfilFragment {
            val fragment = PerfilFragment()
            val bundle = Bundle()
            bundle.putSerializable(ARG_USUARIO, usuario)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuario = arguments?.getSerializable(ARG_USUARIO) as? Usuario
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usuario?.let {
            val nombreCompleto = it.nombre + " " + it.apellidos
            binding.tvInfoNombre.text = nombreCompleto
            binding.tvInfoEmail.text = it.email
        }

        cargarTotales()

        binding.btnBorrarTodosLosLegos.setOnClickListener {
            mostrarDialogoBorrado()
        }
    }

    private fun cargarTotales() {
        lifecycleScope.launch {
            try {
                val totalSets = LegoApplication.database.legoDao().getTotalSets()
                val totalPiezas = LegoApplication.database.legoDao().getTotalPieces()

                binding.tvTotalSetsInfo.text =  totalSets.toString()
                binding.tvTotalPiezasInfo.text = totalPiezas.toString()

            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error cargando totales", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun mostrarDialogoBorrado() {
        AlertDialog.Builder(requireContext())
            .setTitle("Eliminar todos los sets")
            .setMessage("Esta acción eliminará todos los legos guardados. ¿Deseas continuar?")
            .setPositiveButton("Eliminar") { _, _ ->

                lifecycleScope.launch {
                    val deleted =
                        LegoApplication.database
                            .legoDao()
                            .deleteAllSets()

                    Toast.makeText(
                        requireContext(),
                        "Se han eliminado $deleted sets",
                        Toast.LENGTH_SHORT
                    ).show()

                    cargarTotales()
                }
            }
            .setNegativeButton("Cancelar", null)
            .setIcon(R.drawable.ic_lego)
            .show()
    }

}