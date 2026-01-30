package com.example.t9_a2_dura_marcos.ui.viajes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t9_a2_dura_marcos.R
import com.example.t9_a2_dura_marcos.data.ViajeConDestino
import com.example.t9_a2_dura_marcos.databinding.ItemViajeBinding

class ViajeAdapter(private val viajes: List<ViajeConDestino>): RecyclerView.Adapter<ViajeAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_viaje, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val viaje = viajes[position]
        with(holder) {
            binding.tvNombreViaje.text = viaje.viaje.nombreViaje
            binding.tvNombreDestino.text = viaje.destino.nombre
            binding.tvNombreTipo.text = viaje.viaje.tipo
            binding.tvCalendario.text = viaje.viaje.fecha
        }
    }

    override fun getItemCount(): Int = viajes.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemViajeBinding.bind(view)
    }
}