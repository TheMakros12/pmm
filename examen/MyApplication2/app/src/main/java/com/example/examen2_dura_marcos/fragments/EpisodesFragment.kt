package com.example.examen2_dura_marcos.fragments

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
import com.example.examen2_dura_marcos.adapters.EpisodesAdapter
import com.example.examen2_dura_marcos.api.RetrofitInstance
import com.example.examen2_dura_marcos.database.AppDatabase
import com.example.examen2_dura_marcos.database.SimpsonsApp
import com.example.examen2_dura_marcos.databinding.FragmentEpisodesBinding
import kotlinx.coroutines.launch

class EpisodesFragment : Fragment() {

    private lateinit var binding: FragmentEpisodesBinding
    private lateinit var database: AppDatabase
    private lateinit var adapter: EpisodesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = SimpsonsApp.database

        cargarEpisodios()
        cargarRecylcerView()
    }

    private fun cargarEpisodios() {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getEpisodes()
                val episodes = response.results

                //database.episodeDao().insertAll(episodes)
            } catch (e: Exception) {
                Log.e("ERROR", "Error al guardar los episodios")
            }
        }
    }

    private fun cargarRecylcerView() {
        lifecycleScope.launch {
            //val episodios = database.episodeDao().getAll()

            /*if (episodios.isNotEmpty()) {
                adapter = EpisodesAdapter(episodios)
                binding.recyclerViewEpisodes.layoutManager = LinearLayoutManager(requireContext())
                binding.recyclerViewEpisodes.adapter = adapter
            } else {
                Log.e("ERROR", "Error cargando recylcer")
            }*/
        }

    }

}

