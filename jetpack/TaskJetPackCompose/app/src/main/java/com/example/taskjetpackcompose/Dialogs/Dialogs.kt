package com.example.taskjetpackcompose.Dialogs

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun MyDialog(modifier: Modifier) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = { showDialog = true }) {
            Text("Show Dialog")
        }

        if ( showDialog ) {
            Dialog(onDismissRequest = { showDialog = false }) {
                Box(modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp))
                    .padding(20.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Confirm Action",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold)

                        Spacer(modifier = Modifier.height(12.dp))

                        Text("Are you sure you want to perform this action?",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center)

                        Spacer(modifier = Modifier.height(24.dp))

                        Row(horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()) {

                            TextButton(onClick = { showDialog = false } ) {
                                Text("Cancel")
                            }

                            Button(
                                onClick = {
                                    showDialog = false
                                    Toast.makeText(context, "Action Performed", Toast.LENGTH_SHORT).show()}
                            ) {
                                Text("Confirm")
                            }
                        }
                    }

                }
            }
        }
    }
}