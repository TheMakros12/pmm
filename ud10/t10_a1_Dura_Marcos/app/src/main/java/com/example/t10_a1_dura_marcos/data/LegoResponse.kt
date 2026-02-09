package com.example.t10_a1_dura_marcos.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "legos")
data class LegoResponse(
    @PrimaryKey val set_num: String,
    val name: String,
    val theme_id: Int,
    val num_parts: Int,
    val set_img_url: String
)
