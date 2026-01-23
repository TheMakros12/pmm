package com.example.ejemploroom

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemploroom.databinding.ActivityMainBinding
import com.example.ejemploroom.entitites.UserEntity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread {
            val usersEntity: List<UserEntity> =
                listOf(
                    UserEntity(nombre = "Marcos", apellidos = "Durá Blasco"),
                    UserEntity(nombre = "Lucia", apellidos = "Calatayud Oliver"),
                    UserEntity(nombre = "David", apellidos = "Gascó Rubio"),
                    UserEntity(nombre = "Mireia", apellidos = "Rubió Pla")
                )

            UserApplication.database.userDao().insertUsers(usersEntity)
        }.start()

        Thread {
            val userEntities: List<UserEntity> =
                UserApplication.database.userDao().getAll()

            for (user in userEntities) {
                Log.i("UserEntity", "User: ${user.id} " + "${user.nombre}" + "${user.apellidos}")
            }
        }.start()

    }

}