package com.example.ejemplofirebase

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplofirebase.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = FirebaseFirestore.getInstance()

        db.collection("productos")
            .get()
            .addOnSuccessListener {
                    result ->
                for(document in result){
                    val nombre = document.getString("nombre")
                    val precio = document.getDouble("precio")
                    Log.d("FIREBASE","Producto: $nombre - Precio: $precio")
                }
            }
            .addOnFailureListener {
                    e ->
                Log.e("Firebase","Error en la lectura de los productos",e)
            }

        val nuevoProducto=hashMapOf(
            "nombre" to "Medion LG120",
            "precio" to 2760
        )
        db.collection("productos")
            .add(nuevoProducto)
            .addOnSuccessListener {
                Log.d("FIREBASE","Producto añadido correctamente")
            }
            .addOnFailureListener { e ->
                Log.e("FIREBASE","Error al añadir el producto")
            }

        auth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            val correo = binding.etCorreo.text.toString()
            Log.i("Correo", "$correo")
            val passwd = binding.etPassword.text.toString()
            Log.i("Passwd", "$passwd")

            auth.signInWithEmailAndPassword(correo,passwd)
                .addOnSuccessListener {
                    Log.d("Autenticación", "Login Correcto ${auth.currentUser?.email}")
                }
                .addOnFailureListener {
                    e ->
                    Log.e("Autenticación", "Error en el Logoin", e)
                }
        }

    }

}