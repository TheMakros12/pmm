package com.example.ejemploroom2

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.ejemploroom2.database.AppDatabase
import com.example.ejemploroom2.entities.EquipoConJugadores
import com.example.ejemploroom2.entities.EquipoEntity
import com.example.ejemploroom2.entities.JugadorEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "DB_Furbo"
        ).build()

        val dao = db.equipoDao()

        CoroutineScope(Dispatchers.IO).launch {
            val equipoId = dao.insertarEquipo(e = EquipoEntity(nombre = "Olimpic de Xativa")).toInt()
            val equipoIdMadrid = dao.insertarEquipo(e = EquipoEntity(nombre = "Real Madrid")).toInt()
            val equipoIdbarca = dao.insertarEquipo(e = EquipoEntity(nombre = "FC Barcelona")).toInt()

            dao.insertarJugador(JugadorEntity(nombre = "Mbappe", equipoId = equipoIdMadrid))
            dao.insertarJugador(JugadorEntity(nombre = "Lamine Yamal", equipoId = equipoIdbarca))

            val equipoConJugadores = dao.getEquipoConJugadores(equipoIdMadrid)

            Log.i("Equipo: ", "${equipoConJugadores.equipo.nombre}")

            equipoConJugadores.jugadores.forEach {
                Log.i("Jugadores: ", "${it.nombre}")
            }
        }

    }

}