package com.example.estadosjetpack.animaciones

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.scaleIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Animacion(modifier: Modifier) {
    var seleccion: Boolean by remember { mutableStateOf( false) }
    val colorAnimacion: Color by animateColorAsState(
        targetValue = if ( seleccion ) Color.LightGray else Color.DarkGray
    )
    val animacionTamanyo = if ( seleccion ) 300.dp else 150.dp

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(top = 64.dp)) {

        Spacer(Modifier.height(50.dp))

        Button(onClick = { seleccion = !seleccion }) {
            Text("clicar")
        }

        AnimatedVisibility(seleccion) {
            Box(modifier.size(animacionTamanyo).background(colorAnimacion))
        }
    }

}