package com.example.t3a3_profe.activities

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.t3a3_profe.R
import com.example.t3a3_profe.databinding.ActivityTransferBinding

class TransferActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransferBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityTransferBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinnerCuentaPropia()
        configurarRadioButtons()
    }

    private fun setupSpinnerCuentaPropia() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.cuentas_array,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerCuentaOrigen.adapter = adapter
        binding.spinnerCuentaPropia.adapter = adapter
    }

    private fun configurarRadioButtons() {
        binding.radioGroupDestino.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rdBtnCuentaPropia -> {
                    binding.spinnerCuentaPropia.visibility = View.VISIBLE
                    binding.tiLayoutCuentaAjena.visibility = View.GONE
                }
                R.id.rdBtnCuentaAjena -> {
                    binding.spinnerCuentaPropia.visibility = View.GONE
                    binding.tiLayoutCuentaAjena.visibility = View.VISIBLE
                }
            }
        }
    }

}