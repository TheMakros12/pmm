package com.example.reto05_dragon_ball.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reto05_dragon_ball.R
import com.example.reto05_dragon_ball.adapters.DragonBallAdapter
import com.example.reto05_dragon_ball.api.RetrofitInstance
import com.example.reto05_dragon_ball.data.Character
import com.example.reto05_dragon_ball.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DragonBallAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        cargarRecyclerView()
    }

    private fun cargarRecyclerView() {
        lifecycleScope.launch {
            adapter = DragonBallAdapter(mutableListOf(),
                onItemClick = { character ->
                    showDescription(character)
                })

            val result = RetrofitInstance.api.getCharacters()
            val characters = result.items
            adapter.setCharacters(characters)

            binding.recyclerView.adapter = adapter
        }
    }

    private fun showDescription(character: Character) {
        com.google.android.material.dialog.MaterialAlertDialogBuilder(this)
            .setTitle("Character Description")
            .setMessage("${character.description}")
            .setNegativeButton("Cerrar") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}