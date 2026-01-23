package com.example.examen_dura_marcos.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.size
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_dura_marcos.R
import com.example.examen_dura_marcos.databinding.ItemEventBinding
import com.example.examen_dura_marcos.pojo.Evento
import kotlin.contracts.contract

class EventoAdapter(private val eventos: List<Evento>, private val listener: OnClickListener): RecyclerView.Adapter<EventoAdapter.ViewHolder>() {

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
        val evento = eventos[position]
        with(holder) {
            itemView.setOnClickListener {
                listener.onClick(evento)
            }
            binding.tvEventTittle.text = evento.titulo
            binding.tvEventCategory.text = evento.categoria
        }
    }

    override fun getItemCount(): Int = eventos.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemEventBinding.bind(view)
        fun setListener(evento: Evento) {
            binding.root.setOnClickListener {
                listener.onClick(evento)
            }
        }
    }

}