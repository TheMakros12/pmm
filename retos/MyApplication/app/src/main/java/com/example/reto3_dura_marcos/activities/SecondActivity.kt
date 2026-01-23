package com.example.reto3_dura_marcos.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.reto3_dura_marcos.R
import com.example.reto3_dura_marcos.databinding.ActivitySecondBinding
import com.example.reto3_dura_marcos.fragments.WebFragment

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("url")

        val fragment = WebFragment.newInstance(url ?: "")

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentWeb, fragment)
            .commit()

    }

}