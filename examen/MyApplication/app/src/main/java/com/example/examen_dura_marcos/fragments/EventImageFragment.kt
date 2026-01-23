package com.example.examen_dura_marcos.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.examen_dura_marcos.R
import com.example.examen_dura_marcos.databinding.FragmentEventImageBinding

class EventImageFragment : Fragment() {

    private lateinit var binding: FragmentEventImageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun updateImage(imageRes: Int) {
        binding.ivCartelGrande.setImageResource(imageRes)
    }

}