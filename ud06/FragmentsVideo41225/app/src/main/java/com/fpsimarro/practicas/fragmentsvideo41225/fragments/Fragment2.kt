package com.fpsimarro.practicas.fragmentsvideo41225.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.fpsimarro.practicas.fragmentsvideo41225.R
import com.fpsimarro.practicas.fragmentsvideo41225.databinding.Fragment1Binding
import com.fpsimarro.practicas.fragmentsvideo41225.databinding.Fragment2Binding


class Fragment2 : Fragment() {

    private var _binding: Fragment2Binding? = null
    //propiedad con getter personalizado
    //intentamos asegurar que el binding no sea nulo
    private val binding get() = _binding!!

    interface ComunicadorFragments{
        fun recibirDato(dato:String)
    }

    private var activityContenedora: ComunicadorFragments?=null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ComunicadorFragments)
            activityContenedora=context
        //activityContenedora= context as ComunicadorFragments?
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= Fragment2Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        _binding!!.btn5.setOnClickListener {
            val et: EditText=binding.edNombre
            activityContenedora?.recibirDato(et.text.toString())
        }
    }



}