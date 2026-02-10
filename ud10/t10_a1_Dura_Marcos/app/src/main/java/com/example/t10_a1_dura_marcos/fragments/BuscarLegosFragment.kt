package com.example.t10_a1_dura_marcos.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t10_a1_dura_marcos.adapters.LegoAdapter
import com.example.t10_a1_dura_marcos.api.RetrofitInstance
import com.example.t10_a1_dura_marcos.data.LegoResponse
import com.example.t10_a1_dura_marcos.database.AppDatabase
import com.example.t10_a1_dura_marcos.database.LegoApplication
import com.example.t10_a1_dura_marcos.databinding.FragmentBuscarLegosBinding
import kotlinx.coroutines.launch


class BuscarLegosFragment : Fragment() {

    private lateinit var binding: FragmentBuscarLegosBinding
    private lateinit var legoAdapter: LegoAdapter
    private val categorias = arrayOf("Technic", "Speed Champions", "Icons", "Star Wars", "Botanicals", "Marvel")
    private lateinit var themes: Map<Int, String>
    private val themesId = mapOf(
        "Technic" to 1,
        "Speed Champions" to 601,
        "Icons" to 721,
        "Star Wars" to 171,
        "Botanicals" to 769,
        "Marvel" to 702
    )

    private val localThemesMap = mapOf(
        1 to "Technic",
        601 to "Speed Champions",
        721 to "Icons",
        171 to "Star Wars",
        769 to "Botanicals",
        702 to "Marvel"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuscarLegosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recylerViewLegos.layoutManager = LinearLayoutManager(requireContext())

        cargarThemes {
            setupRecyclerView()
            cargarSpinner()
            setupSpinnerListener()
            cargarSetsIniciales()
        }

    }

    private fun setupRecyclerView() {
        legoAdapter = LegoAdapter(mutableListOf(), themes) { lego ->
            guardarLego(lego)
        }
        binding.recylerViewLegos.adapter = legoAdapter
    }

    private fun cargarSpinner() {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categorias)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCategorias.adapter = adapter
    }

    private fun cargarThemes(onLoaded: () -> Unit) {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getThemes()
                val apiThemes = response.results.associate { it.id to it.name }
                themes = apiThemes + localThemesMap
                onLoaded()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error cargando categorías", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun cargarSetsIniciales() {
        val firstThemeId = themesId[categorias[0]] ?: return

        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getSets(firstThemeId)
                legoAdapter.setItems(response.results)
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error cargando sets", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupSpinnerListener() {
        binding.spinnerCategorias.onItemSelectedListener =
            object : android.widget.AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: android.widget.AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selected = categorias[position]
                    val themeId = themesId[selected] ?: return

                    lifecycleScope.launch {
                        try {
                            val response = RetrofitInstance.api.getSets(themeId)
                            legoAdapter.setItems(response.results)
                        } catch (e: Exception) {
                            Toast.makeText(requireContext(), "Error en la API", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onNothingSelected(parent: android.widget.AdapterView<*>?) {}
            }
    }

    private fun guardarLego(legoResponse: LegoResponse) {
        lifecycleScope.launch {
            try {
                val resultado = LegoApplication.database.legoDao().insertSet(legoResponse)

                if (resultado > 0) {
                    Toast.makeText(requireContext(), "Has guardado el Lego ${legoResponse.set_num.split("-")[0]}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Este Lego ya estaba guardado", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error guardando el Lego", Toast.LENGTH_SHORT).show()
            }
        }
    }

}