package com.example.jetpackcompose

import android.util.Log
import android.view.RoundedCorner
import androidx.compose.material3.Button
import androidx.compose.foundation.shape.
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyButton(modifier: Modifier) {
    Button(onClick =  {
        Log.i("Button", "onClick")
    }, enabled = true,
        shape = RoundedCorner) { }
}