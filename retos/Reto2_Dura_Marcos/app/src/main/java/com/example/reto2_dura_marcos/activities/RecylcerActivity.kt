package com.example.reto2_dura_marcos.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reto2_dura_marcos.adapters.OnClickListener
import com.example.reto2_dura_marcos.adapters.PersonajeAdapter
import com.example.reto2_dura_marcos.databinding.ActivityRecylcerBinding
import com.example.reto2_dura_marcos.pojos.Personaje

class RecylcerActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityRecylcerBinding
    private lateinit var personajeAdapter: PersonajeAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRecylcerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linearLayoutManager = LinearLayoutManager(this)
        itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        val item = intent.getStringExtra("item")

        when(item) {
            "pokemon" -> {
                binding.recyclerView.apply {
                    personajeAdapter = PersonajeAdapter(getPokemons(), this@RecylcerActivity)
                    layoutManager = linearLayoutManager
                    adapter = personajeAdapter
                    addItemDecoration(itemDecoration)
                }
            }
            "dragon" -> {
                binding.recyclerView.apply {
                    personajeAdapter = PersonajeAdapter(getDragons(), this@RecylcerActivity)
                    layoutManager = linearLayoutManager
                    adapter = personajeAdapter
                    addItemDecoration(itemDecoration)
                }
            }
            else -> Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
        }



    }

    override fun onClick(personaje: Personaje) {
        Toast.makeText(this, personaje.nombre, Toast.LENGTH_SHORT).show()
    }

    private fun getPokemons(): MutableList<Personaje> {
        val pokemons = mutableListOf<Personaje>()

        val pokemon1 = Personaje("Pikachu")
        val pokemon2 = Personaje("Charmander")
        val pokemon3 = Personaje("Bulbasaur")
        val pokemon4 = Personaje("Squirtle")
        val pokemon5 = Personaje("Jigglypuff")
        val pokemon6 = Personaje("Meowth")
        val pokemon7 = Personaje("Psyduck")
        val pokemon8 = Personaje("Snorlax")
        val pokemon9 = Personaje("Eevee")
        val pokemon10 = Personaje("Gengar")
        val pokemon11 = Personaje("Charizard")
        val pokemon12 = Personaje("Mewtwo")
        val pokemon13 = Personaje("Gyarados")
        val pokemon14 = Personaje("Lapras")
        val pokemon15 = Personaje("Dragonite")
        val pokemon16 = Personaje("Lucario")
        val pokemon17 = Personaje("Blaziken")

        pokemons.add(pokemon1)
        pokemons.add(pokemon2)
        pokemons.add(pokemon3)
        pokemons.add(pokemon4)
        pokemons.add(pokemon5)
        pokemons.add(pokemon6)
        pokemons.add(pokemon7)
        pokemons.add(pokemon8)
        pokemons.add(pokemon9)
        pokemons.add(pokemon10)
        pokemons.add(pokemon11)
        pokemons.add(pokemon12)
        pokemons.add(pokemon13)
        pokemons.add(pokemon14)
        pokemons.add(pokemon15)
        pokemons.add(pokemon16)
        pokemons.add(pokemon17)

        return pokemons
    }

    private fun getDragons(): MutableList<Personaje> {
        val dragons = mutableListOf<Personaje>()

        val dragon1 = Personaje("Goku")
        val dragon2 = Personaje("Vegeta")
        val dragon3 = Personaje("Gohan")
        val dragon4 = Personaje("Piccolo")
        val dragon5 = Personaje("Trunks")
        val dragon6 = Personaje("Krillin")
        val dragon7 = Personaje("Freezer")
        val dragon8 = Personaje("Cell")
        val dragon9 = Personaje("Majin ")
        val dragon10 = Personaje("Buu")
        val dragon11 = Personaje("Broly")
        val dragon12 = Personaje("Beerus")
        val dragon13 = Personaje("Whis")
        val dragon14 = Personaje("Nappa")
        val dragon15 = Personaje("Nappa")
        val dragon16 = Personaje("Nappa")
        val dragon17 = Personaje("Nappa")

        dragons.add(dragon1)
        dragons.add(dragon2)
        dragons.add(dragon3)
        dragons.add(dragon4)
        dragons.add(dragon5)
        dragons.add(dragon6)
        dragons.add(dragon7)
        dragons.add(dragon8)
        dragons.add(dragon9)
        dragons.add(dragon10)
        dragons.add(dragon11)
        dragons.add(dragon12)
        dragons.add(dragon13)
        dragons.add(dragon14)
        dragons.add(dragon15)
        dragons.add(dragon16)
        dragons.add(dragon17)

        return dragons
    }

}