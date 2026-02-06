package com.example.reto_libreria.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reto_libreria.R
import com.example.reto_libreria.data.Libro
import com.example.reto_libreria.databinding.ItemLibroBinding

class LibroAdapter(private val libros: MutableList<Libro>): RecyclerView.Adapter<LibroAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_libro, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val libro = libros[position]
        with(holder) {
            binding.tvNombreLibro.text = libro.nombre
            binding.tvAutorLibro.text = libro.autor
        }
    }

    override fun getItemCount(): Int = libros.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemLibroBinding.bind(view)
    }

    fun actualizarLibros(nuevosLibros: List<Libro>) {
        libros.clear()
        libros.addAll(nuevosLibros)
        notifyDataSetChanged()
    }

}