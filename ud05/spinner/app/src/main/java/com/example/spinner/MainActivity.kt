package com.example.spinner

import android.R
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
import com.example.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var perfiles = arrayOf("Administrador", "Usuario", "Invitado")

    private var primeraVez = true

    private lateinit var descripciones: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarSpinner2(binding.spinner)

    }

    private fun configurarSpinner(spinner: Spinner) {
        //Adaptador
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, perfiles)
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
                val seleccionado = perfiles[posicion]
                //Le damo un efecto visual
                Toast.makeText(this@MainActivity, "Perfil: $seleccionado", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    private fun configurarSpinner2(spinner: Spinner) {

        try {
            descripciones = resources.getStringArray(com.example.spinner.R.array.decripciones_spinner)
        } catch (e: Exception) {
            descripciones = arrayOf("Sin Datos", "Sin Datos", "Sin Datos")
        }

        //Adaptador
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, perfiles)
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
                if (primeraVez) {
                    primeraVez = false
                } else {
                    mostrarDialogo(posicion)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    private fun mostrarDialogo(posicion: Int) {
        //Usamos un builder
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)

        builder.setTitle("Detalles de perfil")
        builder.setMessage(descripciones[posicion])
        builder.setPositiveButton("Entendido") { dialog, _ -> dialog.dismiss()}
        val dialog = builder.create()
        dialog.show()
    }

}