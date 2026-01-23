package com.example.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [PrimerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PrimerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var nombre: String? = null
    private var direccion: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nombre = it.getString(NOMBRE_BUNDLE)
            direccion = it.getString(DIRECCION_BUNDLE)
            Log.i("nombre", nombre.toString())
            Log.i("direccion", direccion.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primer, container, false)
    }

    companion object {
        const val NOMBRE_BUNDLE = "nombre"
        const val DIRECCION_BUNDLE = "direccion"
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(nombre: String, direccion: String) =
            PrimerFragment().apply {
                arguments = Bundle().apply {
                    putString(NOMBRE_BUNDLE, nombre)
                    putString(DIRECCION_BUNDLE, direccion)
                }
            }
    }
}