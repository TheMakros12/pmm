package com.example.t3a3_profe.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.t3a3_profe.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener {

            val actual = binding.tietActual.text.toString()
            val nueva = binding.tietNueva.text.toString()
            val confirmar = binding.tietConfirmar.text.toString()

            if (actual.isEmpty() || nueva.isEmpty() || confirmar.isEmpty()) {
                Toast.makeText(this, "Campos obligatorios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (nueva != confirmar) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Contraseña cambiada correctamente", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnCancelar.setOnClickListener {
            finish()
        }
    }
}
