package com.example.t10_a1_dura_marcos.data

data class ThemesApiResponse(
    val results: List<Theme>
)

data class Theme(
    val id: Int,
    val name: String
)
