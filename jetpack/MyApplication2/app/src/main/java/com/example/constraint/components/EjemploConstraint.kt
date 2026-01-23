package com.example.constraint.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyConstraintLayout(modifier: Modifier) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val(boxRed, boxMagenta, boxCyan, boxBlue, boxYellow) = createRefs()
        Box(modifier = Modifier.background(Color.Red).size(138.dp).constrainAs(boxRed) {
            end.linkTo(parent.end)
            top.linkTo(boxBlue.bottom)
        })
        Box(modifier = Modifier.background(Color.Magenta).size(138.dp).constrainAs(boxMagenta) {
            bottom.linkTo(boxBlue.top)
        })
        Box(modifier = Modifier.background(Color.Cyan).size(138.dp).constrainAs(boxCyan) {
            end.linkTo(parent.end)
            bottom.linkTo(boxBlue.top)
        })
        Box(modifier = Modifier.background(Color.Blue).size(138.dp).constrainAs(boxBlue) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        })
        Box(modifier = Modifier.background(Color.Yellow).size(138.dp).constrainAs(boxYellow) {
            start.linkTo(parent.start)
            top.linkTo(boxBlue.bottom)
        })
    }

}