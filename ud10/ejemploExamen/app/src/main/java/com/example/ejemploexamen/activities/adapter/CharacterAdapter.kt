package com.example.ejemploexamen.activities.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemploexamen.R
import com.example.ejemploexamen.api.Character
import com.example.ejemploexamen.databinding.ItemCharacterBinding
import com.squareup.picasso.Picasso

class CharacterAdapter(private val characters: List<Character>) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_character, parent, false);
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val character = characters[position]

        with (holder) {
            binding.tvNameCharacter.text = character.name
            binding.tvStatusCharacter.text = binding.tvStatusCharacter.text.toString() + character.status
            binding.tvSpeciesCharacter.text = binding.tvSpeciesCharacter.text.toString() + character.species

            Picasso.get()
                .load(character.image)
                .into(binding.ivImgCharacter)
        }
    }

    override fun getItemCount(): Int = characters.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCharacterBinding.bind(view)
    }

}