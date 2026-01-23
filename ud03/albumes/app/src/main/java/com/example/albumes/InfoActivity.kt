package com.example.albumes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.albumes.databinding.ActivityInfoBinding
import com.google.gson.Gson

class InfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding  = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val disco = intent.getStringExtra("discoSeleccionado")
        var album: Album? = null;

        if (disco != null) {
            album = Gson().fromJson(disco, Album::class.java)
        }

        binding.apply {
            binding.idAlbum.text = album?.id.toString()
            binding.nombreAlbum.text = album?.nombre
            binding.autorAlbum.text = album?.autor
            binding.anyoAlbum.text = album?.anyo.toString()
            binding.duracionAlbum.text= album?.duracion.toString()
        }


    }
}