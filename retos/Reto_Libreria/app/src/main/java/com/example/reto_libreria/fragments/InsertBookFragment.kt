package com.example.reto_libreria.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.reto_libreria.R
import com.example.reto_libreria.dao.LibroDao
import com.example.reto_libreria.data.Libro
import com.example.reto_libreria.database.LibroApplication
import com.example.reto_libreria.databinding.FragmentInsertBookBinding
import kotlinx.coroutines.launch

class InsertBookFragment : Fragment(R.layout.fragment_insert_book) {

    private lateinit var binding: FragmentInsertBookBinding
    private lateinit var libroDao: LibroDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInsertBookBinding.bind(view)
        libroDao = LibroApplication.database.libroDao()

        binding.btnInsertarLibro.setOnClickListener {
            val nombreLibro = binding.etNombreLibro.text.toString().trim()
            val autorLibro = binding.etAutorLibro.text.toString().trim()

            if (nombreLibro.isBlank() || autorLibro.isBlank()) {
                Toast.makeText(requireContext(), "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch {
                libroDao.insert(Libro(nombre = nombreLibro, autor = autorLibro))
                parentFragmentManager.popBackStack()
            }
        }
    }
}
