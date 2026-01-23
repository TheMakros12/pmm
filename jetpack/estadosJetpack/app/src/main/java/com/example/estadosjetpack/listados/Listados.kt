package com.example.estadosjetpack.listados

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MiLista(modifier: Modifier, onItemClick: (String) -> Unit = {}) {
    val nombres: List<String> = listOf(
        "marcos",
        "lucia",
        "paula",
        "david",
        "marcos",
        "lucia",
        "paula",
        "david",
        "marcos",
        "lucia",
        "paula",
        "david",
        "marcos",
        "lucia",
        "paula",
        "david",
        "marcos",
        "lucia",
        "paula",
        "david"
    )

    /*Column(modifier = modifier) {
        nomres.forEach {
            Text(it)
        }
    }*/

    LazyColumn(modifier = modifier) {
        items(items=nombres) {
            Text(it, modifier =
                Modifier
                    .clickable{onItemClick(it)}
                    .padding(24.dp)
                    .background(Color.LightGray))

        }
    }

}