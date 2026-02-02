package com.example.reto4_dura_marcos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.reto6_dura_marcos.R
import com.example.reto6_dura_marcos.adapters.LibroAdapter
import com.example.reto6_dura_marcos.data.AppDatabase
import com.example.reto6_dura_marcos.data.Libro
import com.example.reto6_dura_marcos.data.LibroApplication
import com.example.reto6_dura_marcos.data.LibroDao
import com.example.reto6_dura_marcos.databinding.FragmentInsertBookBinding
import kotlinx.coroutines.launch

class InsertBookFragment : Fragment(R.layout.fragment_insert_book) {

    private lateinit var binding: FragmentInsertBookBinding
    private lateinit var libroDao: LibroDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInsertBookBinding.bind(view)
        libroDao = LibroApplication.database.libroDao()

        binding.btnInsertarLibro.setOnClickListener {
            val nombreLibro = binding.etNombreLibro.text.toString()
            val autorLibro = binding.etAutorLibro.text.toString()

            lifecycleScope.launch {
                libroDao.insert(Libro(nombre = nombreLibro, autor = autorLibro))
            }

            childFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ListBooksFragment())
                .commit()
        }

    }

}

