package com.example.mis_albumes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mis_albumes.databinding.ActivityInfoBinding
import com.google.gson.Gson

class InfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val album = intent.getStringExtra("album")
        var albumSeleccionado: Album? = null

        if (album != null) {
            albumSeleccionado = Gson().fromJson(album, Album::class.java)
        }

        binding.apply {
            binding.txtIdAlbum.text = albumSeleccionado?.id.toString()
            binding.txtTituloAlbum.text = albumSeleccionado?.titulo
            binding.txtArtistaAlbum.text = albumSeleccionado?.artista
            binding.txtAnyoAlbum.text = albumSeleccionado?.anyo.toString()
            binding.txtDuracionAlbum.text = (albumSeleccionado?.duracion.toString() + " min")
        }

    }

}