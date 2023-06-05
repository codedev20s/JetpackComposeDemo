package com.android.jetpackcomposedemo.data

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DefaultErrorScreen(msg: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(
            text = msg
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultErrorScreenPreview() {
    DefaultErrorScreen(msg = "Error")
}

@Composable
fun DefaultLoaderScreen() {
    Box {
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultLoaderScreenPreview() {
    DefaultLoaderScreen()

}