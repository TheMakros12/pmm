package com.example.jetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyRow(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center) {
        Text("Hola", modifier = Modifier
            .background(Color.LightGray))

        Text("Adiós", modifier = Modifier
            .background(Color.Magenta))

        Text("Marcos", modifier = Modifier
            .background(Color.Yellow))

        Text("Lucia", modifier = Modifier
            .background(Color.Blue))
    }
}