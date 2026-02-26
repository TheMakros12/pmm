package com.example.ejemploexamen.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejemploexamen.adapter.CharacterAdapter
import com.example.ejemploexamen.api.Character
import com.example.ejemploexamen.database.AppDatabase
import com.example.ejemploexamen.database.CharacterApplication
import com.example.ejemploexamen.databinding.FragmentRoomBinding
import kotlinx.coroutines.launch

class RoomFragment : Fragment() {

    private lateinit var binding: FragmentRoomBinding
    private lateinit var db: AppDatabase
    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRoomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = CharacterApplication.database

        binding.btnCargarDatos.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val lista = db.characterDao().getAll()
                    Log.e("ROOM_TEST", "Cantidad ${lista.size}")

                    if ( lista.isEmpty() ) {
                        binding.tvEstado.text = "No hay datos"
                    } else {
                        binding.tvEstado.text = "Mostrando datos..."
                        cargarRecyclerView(lista)
                    }
                } catch (e: Exception) {
                    binding.tvEstado.text = "Error!!!"
                }
            }
        }

        binding.btnVolver.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun cargarRecyclerView(lista: List<Character>) {
        adapter = CharacterAdapter(lista)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

}