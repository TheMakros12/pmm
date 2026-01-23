package com.example.barralateral.activities

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.barralateral.R
import com.example.barralateral.databinding.ActivityMainBinding
import com.example.barralateral.fragments.HomeFragment
import com.example.barralateral.fragments.ProfileFragment
import com.example.barralateral.fragments.SettingsFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

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

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
            binding.navView.setCheckedItem(R.id.nav_home)
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> replaceFragment(HomeFragment())
            R.id.nav_profile -> replaceFragment(ProfileFragment())
            R.id.nav_settings -> replaceFragment(SettingsFragment())
            R.id.nav_exit -> {
                Toast.makeText(this, "Sing out", Toast.LENGTH_SHORT).show()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}