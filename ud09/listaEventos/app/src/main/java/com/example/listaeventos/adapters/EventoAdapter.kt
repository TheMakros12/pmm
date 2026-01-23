package com.example.listaeventos.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listaeventos.R
import com.example.listaeventos.databinding.ItemEventBinding
import com.example.listaeventos.entities.Evento

class EventoAdapter(private val eventos: MutableList<Evento>,
                    private val onEliminarClick: (Evento) -> Unit): RecyclerView.Adapter<EventoAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val evento = eventos.get(position)
        with(holder) {
            binding.tvTituloEvento.text = evento.titulo.toString()
            binding.tvFechaEvento.text = evento.fecha.toString()
            holder.binding.btnEliminar.setOnClickListener {
                onEliminarClick(evento)
            }
        }
    }

    override fun getItemCount(): Int = eventos.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemEventBinding.bind(view)
    }

    fun actualizarLista(nuevaLista: List<Evento>) {
        eventos.clear()
        eventos.addAll(nuevaLista)
        notifyDataSetChanged()
    }

}