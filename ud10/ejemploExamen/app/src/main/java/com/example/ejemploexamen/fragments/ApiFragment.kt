package com.example.ejemploexamen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.ejemploexamen.R
import com.example.ejemploexamen.api.RetrofitInstance
import com.example.ejemploexamen.database.AppDatabase
import com.example.ejemploexamen.database.CharacterApplication
import com.example.ejemploexamen.databinding.FragmentApiBinding
import kotlinx.coroutines.launch

class ApiFragment : Fragment() {

    private lateinit var binding: FragmentApiBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentApiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = CharacterApplication.database

        binding.btnIrRoom.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main, RoomFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.btnCargar.setOnClickListener {
            guardarRoom()
        }

    }

    private fun guardarRoom() {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getCharacters()
                val lista = response.results

                db.characterDao().insertAll(lista)
            } catch (e: Exception) {
                binding.tvEstado.text = "ERROR!!! ${e.message}"
            }
        }
    }

}