package com.example.miniretojetpack.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyBoxs(modifier: Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Cyan),
            contentAlignment = Alignment.Center,
            ) {
            Text("Ejemplo 1")
        }

        Row(modifier = Modifier
                .weight(1f)
                .fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),
                contentAlignment = Alignment.TopCenter
            ) {
                Text("Ejemplo 2")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.TopEnd
            ) {
                Text("Ejemplo 3")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Yellow),
                contentAlignment = Alignment.BottomStart
            ) {
                Text("Ejemplo 3")
            }

        }

        Box(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter) {
            Text("Ejemplo 5")
        }
    }
}