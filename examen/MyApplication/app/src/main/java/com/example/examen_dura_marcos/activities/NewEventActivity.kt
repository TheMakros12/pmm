package com.example.examen_dura_marcos.activities

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen_dura_marcos.R
import com.example.examen_dura_marcos.databinding.ActivityNewEventBinding

class NewEventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewEventBinding
    private var categorias = arrayOf("MUSICAL", "CONCIERTO", "INFANTIL")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityNewEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarSpinner(binding.spEventType)

    }

    private fun configurarSpinner(spinner: Spinner) {
        //Adaptador
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categorias)
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //Clase anónima para implementar la interfaz del Spinner

            override fun onItemSelected(
                parent: AdapterView<*>?, //El spinner, donde ocurre el evento
                view: View?, //La vista concreta
                posicion: Int, //Indice del array
                id: Long //El id de la fila, coincide con la posición
            ) {
                //Recuperamos el dato real utilizando la posición
                val seleccionado = categorias[posicion]
                //Le damo un efecto visual
                Toast.makeText(
                    this@NewEventActivity,
                    "Categoria: $seleccionado",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

}