package com.example.dialogos

import android.graphics.Color
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialogos.databinding.ActivityDialogoBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class DialogoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDialogoBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDialogoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUno.setOnClickListener {
            showAlertDialog()
        }

        binding.btnDos.setOnClickListener {
            showSelectionDialog()
        }

        binding.btnTres.setOnClickListener {
            showCustomDialog()
        }

    }

    //Diálogo de Alerta:
    private fun showAlertDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Confirmar Eliminación")
            .setMessage("Está acción eliminará el elemento de manera permanente. ¿Desea continuar?")
        //Botón Positivo -> Acción principal
            .setPositiveButton("Eliminar") {
                dialog, witch ->
                //Agregar botón de Aceptar
                Snackbar.make(binding.root, "Elemento eliminado.", Snackbar.LENGTH_SHORT)
                //Agregar botón dentro del SnackBar
                    .setAction("Deshacer.") {
                        Toast.makeText(this, "Acción deshecha", Toast.LENGTH_SHORT).show()
                    }
                    .setActionTextColor(Color.YELLOW)
                    .show()
            }
        //Botoón Negativo -> Acción de cancelación
            .setNegativeButton("Cancelar") {
                dialog, witch ->
                dialog.dismiss()
            }
            .show()
    }

    private fun showSelectionDialog() {
        val perfiles = arrayOf("Admin", "Developer", "User")

        MaterialAlertDialogBuilder(this)
            .setTitle("Selección de Perfil")

            .setItems(perfiles) {
                dialog, index ->
                val perfilSeleccionado = perfiles[index]

                Snackbar.make(
                    binding.root,
                    "Perfil Cargado: $perfilSeleccionado",
                    Snackbar.LENGTH_SHORT
                )

                    .setTextColor(Color.GREEN)
                    .show()
                dialog.dismiss()
            }
            .setNeutralButton("Información", null)
    }

    private fun showCustomDialog() {
        //Inflar el XML que hemos disñado
        val customView = LayoutInflater.from(this).inflate(R.layout.dialog_quick_note, null)

        val etQuickNote = customView.findViewById<EditText>(R.id.editText)

        MaterialAlertDialogBuilder(this)
            .setTitle("Añadir nota rápida")
            .setView(customView)
            .setPositiveButton("Guardar") {
                dialog, witch ->
                val nota = etQuickNote.text.toString()
                if (nota.isBlank()) {
                    Toast.makeText(this, "Nota guardada y mostrada", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Nota NO guardada, no hay texto", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Descartar", null)
            .setCancelable(true)
            .show()
    }

}