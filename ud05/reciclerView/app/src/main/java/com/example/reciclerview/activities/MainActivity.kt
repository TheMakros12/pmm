package com.example.reciclerview.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reciclerview.R
import com.example.reciclerview.adapters.OnClickListener
import com.example.reciclerview.adapters.UserAdapter
import com.example.reciclerview.databinding.ActivityMainBinding
import com.example.reciclerview.pojos.User

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter(getUsers(),this)
        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager=linearLayoutManager
            adapter = userAdapter
        }

    }

    private fun getUsers(): MutableList<User>{
        val users = mutableListOf<User>()

        val marcos = User(1, "Marcos", "Dura", "https://randomuser.me/api/portraits/men/1.jpg")
        val lucia = User(2, "Lucia", "Calatayud", "https://randomuser.me/api/portraits/women/1.jpg")
        val david = User(3, "David", "Gasco", "https://randomuser.me/api/portraits/men/2.jpg")
        val josep = User(4, "Josep", "Miquel", "https://randomuser.me/api/portraits/men/3.jpg")

        users.add(marcos)
        users.add(lucia)
        users.add(david)
        users.add(josep)
        users.add(marcos)
        users.add(lucia)
        users.add(david)
        users.add(josep)
        users.add(marcos)
        users.add(lucia)
        users.add(david)
        users.add(josep)
        users.add(marcos)
        users.add(lucia)
        users.add(david)
        users.add(josep)
        users.add(marcos)
        users.add(lucia)
        users.add(david)
        users.add(josep)
        users.add(marcos)
        users.add(lucia)
        users.add(david)
        users.add(josep)

        return users
    }

    override fun onClik(user: User) {
        Toast.makeText(this, user.nombre, Toast.LENGTH_SHORT).show()
    }

}