package com.example.reto_libreria.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reto_libreria.R
import com.example.reto_libreria.adapter.LibroAdapter
import com.example.reto_libreria.dao.LibroDao
import com.example.reto_libreria.data.Libro
import com.example.reto_libreria.database.LibroApplication
import com.example.reto_libreria.databinding.FragmentListBookBinding
import kotlinx.coroutines.launch

class ListBookFragment : Fragment(R.layout.fragment_list_book) {

    private lateinit var binding: FragmentListBookBinding
    private lateinit var libroAdapter: LibroAdapter
    private lateinit var libroDao: LibroDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBookBinding.bind(view)
        libroDao = LibroApplication.database.libroDao()

        binding.btnAnyadirLibro.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, InsertBookFragment())
                .addToBackStack(null)
                .commit()
        }

        setupRecyclerView()
        cargarLibros()
    }

    private fun setupRecyclerView() {
        libroAdapter = LibroAdapter(mutableListOf())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = libroAdapter
        }
    }

    private fun cargarLibros() {
        lifecycleScope.launch {
            val libros: List<Libro> = libroDao.getAll()
            libroAdapter.actualizarLibros(libros)
        }
    }

    override fun onResume() {
        super.onResume()
        cargarLibros()
    }
}
