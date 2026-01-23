package com.fpsimarro.practicas.fragmentsvideo41225.fragments

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.fpsimarro.practicas.fragmentsvideo41225.R
import com.fpsimarro.practicas.fragmentsvideo41225.databinding.Fragment1Binding


class Fragment1 : Fragment() {

  private var _binding: Fragment1Binding? = null
    //propiedad con getter personalizado
    //intentamos asegurar que el binding no sea nulo
  private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= Fragment1Binding.inflate(inflater,container,false)
        return binding.root
    //return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if(arguments!=null){
            val numFragmento=arguments?.getInt("numero")
            binding.edNombre.setText("Hola $numFragmento")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}