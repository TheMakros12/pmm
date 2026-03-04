package com.example.proyectosimagrow.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectosimagrow.R
import com.example.proyectosimagrow.databinding.ItemRecompensaBinding
import com.example.proyectosimagrow.pojo.Recompensa

class RecompensaAdapter(private val recompensas: Array<Recompensa>) : RecyclerView.Adapter<RecompensaAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_recompensa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val recompensa = recompensas[position]
        with(holder) {
            binding.tvNombreRecompensa.text = recompensa.nombre
            binding.tvPrecioRecompensa.text = recompensa.precio.toString()
            /*Glide.with(context)
                .load(filamento.imagen)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.ivFilamento)*/
        }
    }

    override fun getItemCount(): Int = recompensas.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemRecompensaBinding.bind(view)
    }
}