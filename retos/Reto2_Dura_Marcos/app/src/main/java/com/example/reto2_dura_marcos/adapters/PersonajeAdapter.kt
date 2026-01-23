package com.example.reto2_dura_marcos.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reto2_dura_marcos.R
import com.example.reto2_dura_marcos.databinding.ItemAdapterBinding
import com.example.reto2_dura_marcos.pojos.Personaje

class PersonajeAdapter(private val personajes: List<Personaje>, private val listener: OnClickListener): RecyclerView.Adapter<PersonajeAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val personaje = personajes.get(position)
        with(holder) {
            setListener(personaje)
            binding.tvNombre.text = personaje.nombre.toString()
        }
    }

    override fun getItemCount(): Int = personajes.size


    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemAdapterBinding.bind(view)
        fun setListener(personaje: Personaje) {
            binding.root.setOnClickListener {
                listener.onClick(personaje)
            }
        }
    }

}