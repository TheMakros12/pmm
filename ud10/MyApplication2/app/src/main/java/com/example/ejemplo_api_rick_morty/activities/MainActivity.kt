package com.example.ejemplo_api_rick_morty.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejemplo_api_rick_morty.R
import com.example.ejemplo_api_rick_morty.adapters.CharacterAdapter
import com.example.ejemplo_api_rick_morty.api.RetrofitInstance
import com.example.ejemplo_api_rick_morty.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadCharacters()
    }

    private fun setupRecyclerView() {
        adapter = CharacterAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun loadCharacters() {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getCharacters()
                adapter.updateList(response.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}