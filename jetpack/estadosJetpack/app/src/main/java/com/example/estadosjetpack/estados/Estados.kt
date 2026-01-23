package com.example.estadosjetpack.estados

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun Estados(modifier: Modifier) {
    var numero = remember { mutableStateOf(0) }

    Column {
        Text("Clica aquí ${numero.value}",
            modifier = modifier.clickable {
            numero.value++
        })
    }
}

@Composable
fun Estados2(modifier: Modifier) {
    var contador by remember { mutableStateOf(0) }

    Box(modifier = modifier) {
        Button(onClick = {contador++}) {
            Text("Contador ${contador}")
        }
    }
}