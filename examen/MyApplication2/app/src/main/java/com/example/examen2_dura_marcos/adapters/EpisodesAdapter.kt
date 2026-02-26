package com.example.examen2_dura_marcos.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examen2_dura_marcos.R
import com.example.examen2_dura_marcos.api.Episode
import com.example.examen2_dura_marcos.databinding.ItemEpisodeBinding

class EpisodesAdapter(private val episodes: List<Episode>) : RecyclerView.Adapter<EpisodesAdapter.ViewHolder> (){

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_episode, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val episode = episodes[position]

        with(holder) {
            binding.tvNameEpisode.text = episode.name
            binding.tvSeassonEpisode.text = binding.tvSeassonEpisode.text.toString() + episode.season
            binding.tvSinopsisEpisode.text = episode.synopsis
        }
    }

    override fun getItemCount(): Int = episodes.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemEpisodeBinding.bind(view)
    }

}