package com.example.reto05_dragon_ball.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reto05_dragon_ball.R
import com.example.reto05_dragon_ball.data.Character
import com.example.reto05_dragon_ball.databinding.ItemCharacterBinding
import com.squareup.picasso.Picasso

class DragonBallAdapter(private val characters: MutableList<Character>,
                        private val onItemClick: (Character) -> Unit) : RecyclerView.Adapter<DragonBallAdapter.ViewHolder>() {

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
            binding.tvRaceCharacter.text = "Race: ${character.race}"

            Picasso.get()
                .load(character.image)
                .into(binding.ivImageCharacter)

            itemView.setOnClickListener {
                onItemClick(character)
            }
        }
    }

    override fun getItemCount(): Int = characters.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCharacterBinding.bind(view)
    }

    fun setCharacters(nuevosCharacters: List<Character>) {
        characters.clear()
        characters.addAll(nuevosCharacters)
        notifyDataSetChanged()
    }

}