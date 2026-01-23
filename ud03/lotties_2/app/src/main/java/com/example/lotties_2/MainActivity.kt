package com.example.lotties_2

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lotties_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLanzar.setOnClickListener {
            if (binding.animacionAvion.isAnimating) {
                binding.animacionAvion.pauseAnimation()
                binding.btnLanzar.text = "Lanzar"
            } else {
                binding.animacionAvion.resumeAnimation()
                binding.btnLanzar.text = "Pausar"
            }
        }

        configurarControlesAvanzados()

        binding.btnDescargar.setOnClickListener {
            binding.btnDescargar.visibility = View.GONE
            binding.animacionCargando.visibility = View.VISIBLE
            binding.animacionCargando.playAnimation()

            Handler(Looper.getMainLooper()).postDelayed({
                binding.animacionCargando.visibility = View.GONE
                binding.animacionCargando.cancelAnimation()

                binding.animacionExito.visibility = View.VISIBLE
                binding.animacionExito.playAnimation()

            }, 3000)
        }

        binding.fabAccionPrincipal.setOnClickListener {
            Toast.makeText(this, "FAB presionado", Toast.LENGTH_LONG).show()
        }

    }

    private fun configurarControlesAvanzados() {

        binding.btnVelocidadNormal.setOnClickListener { binding.animacionAvion.speed = 1.0f }
        binding.btnVelocidadRapida.setOnClickListener { binding.animacionAvion.speed = 2.0f }
        binding.btnVelocidadInversa.setOnClickListener { binding.animacionAvion.speed = -1.0f }

        binding.seekbarProgreso.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                barraProgreso: SeekBar?,
                progreso: Int,
                esIniciadoPorElUsuario: Boolean
            ) {
                if (esIniciadoPorElUsuario) {
                    binding.animacionAvion.progress = (progreso / 100.0f)
                }
            }

            override fun onStartTrackingTouch(barraProgreso: SeekBar?) {

            }

            override fun onStopTrackingTouch(barraProgreso: SeekBar?) {

            }
        })

        binding.btnReset.setOnClickListener {
            binding.animacionAvion.cancelAnimation()
            binding.btnLanzar.text = "Lanzar"
        }

    }

}