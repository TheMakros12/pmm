package com.example.ejemplo_api_rick_morty.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplo_api_rick_morty.R
import com.example.ejemplo_api_rick_morty.data.Character
import com.example.ejemplo_api_rick_morty.databinding.ItemCharacterBinding
import com.squareup.picasso.Picasso

class CharacterAdapter(private var characters: List<Character>) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

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

        with (holder) {
            binding.tvNameCharacter.text = character.name
            binding.tvStatusCharacter.text = character.status

            Picasso.get()
                .load(character.image)
                .into(binding.ivImageCharacter)
        }
    }

    override fun getItemCount(): Int = characters.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCharacterBinding.bind(view)
    }

    fun updateList(newList: List<Character>) {
        characters = newList
        notifyDataSetChanged()
    }

}