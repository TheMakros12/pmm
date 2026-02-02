package com.example.reto6_dura_marcos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reto6_dura_marcos.R
import com.example.reto6_dura_marcos.adapters.LibroAdapter
import com.example.reto6_dura_marcos.data.LibroDao
import com.example.reto6_dura_marcos.databinding.FragmentListBooksBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListBooksFragment : Fragment(R.layout.fragment_list_books) {

    private lateinit var binding: FragmentListBooksBinding
    private lateinit var libroAdapter: LibroAdapter
    private lateinit var libroDao: LibroDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBooksBinding.bind(view)

        binding.btnAnyadirLibro.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, InsertBookFragment())
                .commit()
        }

        setupRecyclerView()
        cargarLibros()
    }

    private fun setupRecyclerView() {
        libroAdapter = LibroAdapter(mutableListOf())

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ListBooksFragment.libroAdapter
        }
    }

    private fun cargarLibros() {
        lifecycleScope.launch {
            val libros = withContext(Dispatchers.IO) {
                libroDao.getAll()
            }
            libroAdapter.actualizarLibros(libros)
        }
    }

}