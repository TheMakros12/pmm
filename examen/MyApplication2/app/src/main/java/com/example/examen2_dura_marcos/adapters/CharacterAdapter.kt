package com.example.examen2_dura_marcos.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examen2_dura_marcos.R
import com.example.examen2_dura_marcos.api.Character
import com.example.examen2_dura_marcos.databinding.ItemCharacterBinding
import com.squareup.picasso.Picasso

class CharacterAdapter(private val characters: List<Character>) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_character, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val character = characters[position]
        val urlImage = "https://cdn.thesimpsonsapi.com/200" + character.portrait_path

        with (holder) {
            binding.tvNameCharacter.text = character.name
            binding.tvOcupationCharacter.text = character.occupation
            binding.tvStatusCharacter.text = character.status

            Picasso.get()
                .load(urlImage)
                .into(binding.ivImageCharacter)
        }
    }

    override fun getItemCount(): Int = characters.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemCharacterBinding.bind(view)
    }

}