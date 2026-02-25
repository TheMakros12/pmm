package com.example.reto_06_futurama

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.reto_06_futurama.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private lateinit var info: Personaje

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        info = arguments?.getSerializable("personaje") as Personaje
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (info.nombre == "") {
            binding.ivFuturama.visibility = View.VISIBLE
            binding.layoutInfo.visibility = View.GONE
        }

        if (info.nombre == "Bender Bending Rodríguez") {
            binding.ivFuturama.visibility = View.GONE
            binding.layoutInfo.visibility = View.VISIBLE

            binding.nombrePersonaje.text = info.nombre
            binding.descripcionPersonaje.text = info.descripcion
            binding.ivImagenPersonaje.setImageResource(R.drawable.personaje1)
        }

        if (info.nombre == "Philip J.Fry") {
            binding.ivFuturama.visibility = View.GONE
            binding.layoutInfo.visibility = View.VISIBLE

            binding.nombrePersonaje.text = info.nombre
            binding.descripcionPersonaje.text = info.descripcion
            binding.ivImagenPersonaje.setImageResource(R.drawable.personaje2)
        }

        if (info.nombre == "Futurama") {
            binding.ivFuturama.visibility = View.GONE
            binding.layoutInfo.visibility = View.VISIBLE

            binding.nombrePersonaje.text = info.nombre
            binding.descripcionPersonaje.text = info.descripcion
            binding.ivImagenPersonaje.setImageResource(R.drawable.futurama)
        }
    }

}