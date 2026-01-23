package com.example.lotties

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lotties.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        //Lógica de los botones y animaciones

        binding.btnLanzar.setOnClickListener {
            //Comprobamos si la animación del círculo está en uso

            if (binding.vistaAnimacionCirculo.isAnimating) {
                //Pausamos

                binding.vistaAnimacionCirculo.pauseAnimation()
                //Actualizamos el texto
                binding.btnLanzar.text = "Continuar"
            } else {
                //Si está pausada o es la primera vez
                binding.vistaAnimacionCirculo.resumeAnimation()
                //Cambiamos el texto
                binding.btnLanzar.text = "Pausar"
            }
        }

        binding.btnDescargar.setOnClickListener {
            //Ocultamos el botón de descargar para evitar múltiples clicks
            binding.btnDescargar.visibility = View.GONE
            //Mostramos la animación de carga
            binding.vistaAnimacionCargango.visibility = View.VISIBLE
            binding.vistaAnimacionCargango.playAnimation()

            //Herramienta de Android para ejecutar código en el futuro
            Handler(Looper.getMainLooper()).postDelayed({
                binding.vistaAnimacionCargango.visibility  = View.GONE
                //Liberamos los recursos
                binding.vistaAnimacionCargango.cancelAnimation()

                binding.vistaAnimacionExito.visibility = View.VISIBLE
                binding.vistaAnimacionExito.playAnimation()
            }, 3000)
        }

        //Botón FAB
        binding.fabAccionPrincipal.setOnClickListener {
            Toast.makeText(this, "FAB presionado ACCION PRINCIPAL", Toast.LENGTH_SHORT).show()
        }

        configurarControlesAvanzadosCirculo()

    }

    private fun configurarControlesAvanzadosCirculo() {

        //Control de velocidad
        binding.btnVelocidadNormal.setOnClickListener { binding.vistaAnimacionCirculo.speed = 1.0f }
        binding.btnVelocidadRapida.setOnClickListener { binding.vistaAnimacionCirculo.speed = 2.0f }
        binding.btnValocidadInversa.setOnClickListener { binding.vistaAnimacionCirculo.speed = -1.0f }

        //Control de progreso de SeekBar
        binding.seekbarProgreso.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                barraProgreso: SeekBar?,
                progreso: Int,
                esInciadoPorUsuario: Boolean
            ) {
                //Progreso que hace la barra al deslizarse
                //Para evitar bucles infinitos o si el cambio lo hace el usuario
                if (esInciadoPorUsuario) {
                    binding.vistaAnimacionCirculo.progress = progreso / 100f
                }
            }

            override fun onStartTrackingTouch(seekbar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekbar: SeekBar?) {
                TODO("Not yet implemented")
            }
        })

        //Boton Resetear
        binding.btnReset.setOnClickListener {
            binding.vistaAnimacionCirculo.cancelAnimation()
            binding.btnLanzar.text = "Lanzar"
        }

        //Escuchar eventos de la aplicación

    }

}