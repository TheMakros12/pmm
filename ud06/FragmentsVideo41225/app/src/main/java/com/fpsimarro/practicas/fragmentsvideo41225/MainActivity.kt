package com.fpsimarro.practicas.fragmentsvideo41225

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fpsimarro.practicas.fragmentsvideo41225.databinding.ActivityMainBinding
import com.fpsimarro.practicas.fragmentsvideo41225.fragments.Fragment1
import com.fpsimarro.practicas.fragmentsvideo41225.fragments.Fragment2
import com.fpsimarro.practicas.fragmentsvideo41225.fragments.Fragment3

class MainActivity : AppCompatActivity(), Fragment2.ComunicadorFragments {
    lateinit var binding: ActivityMainBinding
    var numFragment=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val bundle= Bundle()
            bundle.putInt("numero",++numFragment)

            val fragment1= Fragment1()
            fragment1.arguments=bundle

            cargarFragment(fragment1)
        }

        binding.btn2.setOnClickListener {
            val fragment2= Fragment2()
            cargarFragment(fragment2)
        }

        binding.btn3.setOnClickListener {
            val fragment3= Fragment3()
            cargarFragment(fragment3)
        }

    }
    fun cargarFragment(fragment: Fragment){
        val transaccion=supportFragmentManager.beginTransaction()

        transaccion.replace(R.id.contenedor,fragment)

        transaccion.addToBackStack(null)

        transaccion.commit()
    }

    override fun recibirDato(dato: String) {
        binding.edNombreMain.setText(dato)
    }
}