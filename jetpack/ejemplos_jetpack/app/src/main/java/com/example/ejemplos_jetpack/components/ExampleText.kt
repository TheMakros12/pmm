package com.example.ejemplos_jetpack.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.ejemplos_jetpack.R

@Composable
fun myText(modifier: Modifier) {
    Column(modifier = modifier) {
        Text("Hola", letterSpacing = 2.sp,
            fontSize = 25.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.clickable{
                Log.i("Click", "Has clicado")
            })

        Text("Hola 2",
            textDecoration = TextDecoration.Underline,
            color = Color.Magenta,
            modifier = Modifier.background(Color.Magenta))

        Text("Hola 3",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough)
    }
}