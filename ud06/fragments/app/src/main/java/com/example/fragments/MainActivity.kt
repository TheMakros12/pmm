package com.example.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.fragments.PrimerFragment.Companion.DIRECCION_BUNDLE
import com.example.fragments.PrimerFragment.Companion.NOMBRE_BUNDLE

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {

            val bundle = bundleOf(NOMBRE_BUNDLE to "Lucia",
                DIRECCION_BUNDLE to "San Joan d'Alacant")

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<PrimerFragment>(R.id.containerFragment, args = bundle)
            }
        }
    }

}