package com.example.t3a3_profe.activities

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
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

        inicializarSpinners()
        configurarRadioButtons()
        configurarBotones()

        binding.rdBtnCuentaPropia.isChecked = true
    }

    private fun inicializarSpinners() {
        val cuentasAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.cuentas_array,
            android.R.layout.simple_spinner_item
        )

        cuentasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerCuentaOrigen.adapter = cuentasAdapter
        binding.spinnerCuentaPropia.adapter = cuentasAdapter

        val divisasAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.divisas_array,
            android.R.layout.simple_spinner_item
        )
        divisasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerDivisa.adapter = divisasAdapter
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

    private fun configurarBotones() {
        binding.btnEnviar.setOnClickListener {
            if ( validarFormulario() ) {
                enviarTransferencia()
                limpiarFormulario()
            }
        }

        binding.btnCancelar.setOnClickListener {
            limpiarFormulario()
        }
    }

    private fun validarFormulario() : Boolean {
        var esValido = true

        binding.tiLayoutImporte.error = null
        binding.tiLayoutCuentaAjena.error = null

        val importeTexto = binding.tiImporte.text.toString()

        if ( importeTexto.isEmpty() ) {
            binding.tiLayoutImporte.error = "El importe no puede estar vacío"
            esValido = false
        } else {
            val importe = importeTexto.toDoubleOrNull()
            if (importe == null || importe <= 0) {
                binding.tiLayoutImporte.error = "Debe ser un número mayor que 0"
                esValido = false
            }
        }

        if (binding.rdBtnCuentaAjena.isChecked) {

            val cuentaAjena = binding.tiCuentaAjena.text.toString()

            if (cuentaAjena.isEmpty()) {
                binding.tiLayoutCuentaAjena.error = "La cuenta no puede estar vacía"
                esValido = false
            } else if (!cuentaAjena.matches(Regex("^[0-9]{16,}$"))) {
                binding.tiLayoutCuentaAjena.error =
                    "Debe contener solo números y mínimo 16 dígitos"
                esValido = false
            }
        }

        return esValido
    }

    private fun enviarTransferencia() {
        val cuentaOrigen = binding.spinnerCuentaOrigen.selectedItem.toString()

        val tipoDestino: String
        val cuentaDestino: String
        if (binding.rdBtnCuentaPropia.isChecked) {
            tipoDestino = "Cuenta Propia"
            cuentaDestino = binding.spinnerCuentaPropia.selectedItem.toString()
        } else {
            tipoDestino = "Cuenta Ajena"
            cuentaDestino = binding.tiCuentaAjena.text.toString()
        }

        val importe = binding.tiImporte.text.toString()
        val divisa = binding.spinnerDivisa.selectedItem.toString()

        val justificante = if ( binding.chBoxEnviarJustificante.isChecked )
            "Sí"
        else
            "No"

        val resumen = """
            Cuenta origen: $cuentaOrigen
            Tipo destino: $tipoDestino
            Cuenta destino: $cuentaDestino
            Importe: $importe $divisa
            Enviar justificante: $justificante
        """.trimIndent()

        AlertDialog.Builder(this)
            .setTitle("Resumen de la transferencia")
            .setMessage(resumen)
            .setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun limpiarFormulario() {
        binding.tiImporte.text?.clear()
        binding.tiCuentaAjena.text?.clear()

        binding.spinnerCuentaOrigen.setSelection(0)
        binding.spinnerCuentaPropia.setSelection(0)
        binding.spinnerDivisa.setSelection(0)

        binding.tiLayoutImporte.error = null
        binding.tiLayoutCuentaAjena.error = null

        binding.chBoxEnviarJustificante.isChecked = false

        binding.rdBtnCuentaPropia.isChecked = true

        binding.spinnerCuentaPropia.visibility = View.VISIBLE
        binding.tiLayoutCuentaAjena.visibility = View.GONE
    }

}