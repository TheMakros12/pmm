package com.example.clase_6_11

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

enum class UserType {ADMIN, USER}

abstract class ActivityBase : AppCompatActivity() {

    abstract val rol: UserType
    abstract val actualItem: Int

    protected fun bottomNavViewConfig(bottomNavView: BottomNavigationView) {
        bottomNavView.menu.clear()

        when (rol) {
            UserType.ADMIN ->  bottomNavView.inflateMenu(R.menu.menu_admin)
            UserType.USER ->  bottomNavView.inflateMenu(R.menu.menu_user)
        }

        bottomNavView.selectedItemId = actualItem

        bottomNavView.setOnItemSelectedListener { item ->
            if (item.itemId == actualItem) {
                return@setOnItemSelectedListener true
            }

            when (item.itemId) {
                R.id.home -> launchTab(MainActivity2::class.java)
                R.id.search -> launchTab(MainActivity2::class.java)
                R.id.profile -> launchTab(MainActivity4::class.java)
                else -> false
            }
        }
    }

    private fun launchTab(destino: Class<out Activity>): Boolean {
        val intent = Intent(this, destino)
        startActivity(intent)
        return true
    }

}