package com.example.proyectosimagrow.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.proyectosimagrow.R
import com.example.proyectosimagrow.databinding.ActivityMainBinding
import com.example.proyectosimagrow.fragments.RecompensasFragment
import com.example.proyectosimagrow.fragments.IncidenciasFragment
import com.example.proyectosimagrow.fragments.NoticiasFragment
import com.example.proyectosimagrow.pojo.Recompensa
import com.example.proyectosimagrow.pojo.User
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userRecibido = intent.getStringExtra("user")
        var user: User? = null

        if (userRecibido != null) {
            user = Gson().fromJson(userRecibido, User::class.java)
        }

        configurarMenu()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun configurarMenu() {
        setSupportActionBar(binding.toolBarInclude.myToolBar)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolBarInclude.myToolBar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close,
        )

        binding.drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_incidencias -> replaceFragment(IncidenciasFragment())
            R.id.nav_nueva_incidencia -> replaceFragment(IncidenciasFragment())
            R.id.nav_recompensas -> replaceFragment(RecompensasFragment())
            R.id.nav_noticias -> replaceFragment(NoticiasFragment())
            R.id.nav_profile -> replaceFragment(NoticiasFragment())
            R.id.nav_exit -> {
                Toast.makeText(this, "Sing out", Toast.LENGTH_SHORT).show()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}