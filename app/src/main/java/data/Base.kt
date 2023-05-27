package com.android.jetpackcomposedemo.data

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Circular
import androidx.compose.material3.CircularProgressIndicator

Progress Indicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier import androidx.compose.ui.tooling.preview.Preview
importandroidx.compose.ui.unit.dp Chimport com.ascendion.base. theme.appTypography

@Composable
fun DefaultErrorScreen (msg: String) {

    Box(contentAlignment Alignment.Center,
        modifier Modifier
                .fillMaxSize()
                .podding(16.dp),
        ) {
        Text(
            text = msg.style = appTypography.defaultTypography.bodyLarge
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultErrorScreenPreview() {
    DefaultErrorScreen (msg = "Error")
}
@Composable
fun DefaultLoaderScreen () {
    Box {
        CircularProgressIndicator()
    }
}
@Preview(showBackground= true)
    @Composable
fun DefaultLoaderScreenPreview() {
    DefaultLoaderScreen()

}