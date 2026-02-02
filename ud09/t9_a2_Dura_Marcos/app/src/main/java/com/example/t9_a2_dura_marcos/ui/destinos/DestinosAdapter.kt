package com.example.t9_a2_dura_marcos.ui.destinos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t9_a2_dura_marcos.R
import com.example.t9_a2_dura_marcos.data.Destino
import com.example.t9_a2_dura_marcos.databinding.ItemDestinoBinding

class DestinosAdapter(private val destinos: MutableList<Destino>, private val onEliminarClick: (Destino) -> Unit): RecyclerView.Adapter<DestinosAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_destino, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val destino = destinos[position]
        with(holder) {
            binding.tvDestino.text = destino.nombre
            binding.btnEliminarDestino.setOnClickListener {
                onEliminarClick(destino)
            }
        }
    }

    override fun getItemCount(): Int = destinos.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemDestinoBinding.bind(view)

    }

    fun actualizarDetinos(nuevosDestinos: List<Destino>) {
        destinos.clear()
        destinos.addAll(nuevosDestinos)
        notifyDataSetChanged()
    }

}