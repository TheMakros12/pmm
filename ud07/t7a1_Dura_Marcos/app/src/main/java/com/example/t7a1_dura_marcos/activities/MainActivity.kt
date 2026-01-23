package com.example.t7a1_dura_marcos.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.t7a1_dura_marcos.R
import com.example.t7a1_dura_marcos.databinding.ActivityMainBinding
import com.example.t7a1_dura_marcos.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "Login Satisfactorio", Toast.LENGTH_SHORT).show()

        val txtUsuario: String? = intent.getStringExtra("usuario")

        binding.tvWelcomeUsuario.text = txtUsuario

        setSupportActionBar(binding.toolBarInclude?.myToolBar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolBarInclude?.myToolBar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)

        binding.drawerLayout?.addDrawerListener(toggle)

        toggle.syncState()

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
            binding.navView?.setCheckedItem(R.id.nav_home)
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

}