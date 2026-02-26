package com.example.examen2_dura_marcos.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examen2_dura_marcos.R
import com.example.examen2_dura_marcos.adapters.CharacterAdapter
import com.example.examen2_dura_marcos.api.Character
import com.example.examen2_dura_marcos.api.RetrofitInstance
import com.example.examen2_dura_marcos.databinding.FragmentCharactersBinding
import com.example.examen2_dura_marcos.databinding.FragmentEpisodesBinding
import kotlinx.coroutines.launch

class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding
    private lateinit var adapter: CharacterAdapter
    private lateinit var personajes: List<Character>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        personajes = emptyList()
        binding.root.setBackgroundColor(Color.WHITE)
        binding.ivImagenSimpsons.visibility = View.GONE
        binding.recyclerViewCharacters.visibility = View.VISIBLE
        cargarPersonajes()
    }

    private fun cargarPersonajes() {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getCharacters()
                personajes = response.results

                if (personajes.isNotEmpty()) {
                    adapter = CharacterAdapter(personajes)
                    binding.recyclerViewCharacters.layoutManager = LinearLayoutManager(requireContext())
                    binding.recyclerViewCharacters.adapter = adapter
                } else {
                    Log.e("ERROR", "Error cargando recylcer")
                }
            } catch (e: Exception) {
                Log.e("ERROR_RETROFIT", "Error al obtener Characters")
            }
        }
    }

}