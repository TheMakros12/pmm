package com.example.reciclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.reciclerview.R
import com.example.reciclerview.databinding.ItemUserBinding
import com.example.reciclerview.pojos.User

class UserAdapter(private val usuarios: List<User>, private val  listener: OnClickListener): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val user = usuarios.get(position)

        with(holder) {
            setListener(user)
            binding.tvOrden.text = user.id.toString()
            binding.tvNombre.text = user.nombre
            Glide.with(context)
                .load(user.imagen)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imgUser)
        }
    }

    override fun getItemCount(): Int = usuarios.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder (view) {

        val binding = ItemUserBinding.bind(view)
        fun setListener(user: User) {
            listener.onClik(user)
        }

    }

}