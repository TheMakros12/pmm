package com.example.jetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyColumn() {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("Hola", modifier = Modifier
            .backgroung(Color.LightGray))

        Text("Adiós", modifier = Modifier
            .backgroung(Color.Magenta))

        Text("Marcos", modifier = Modifier
            .backgroung(Color.Yellow))

        Text("Lucia", modifier = Modifier
            .backgroung(Color.Blue))
    }

}