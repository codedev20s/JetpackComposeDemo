package com.android.base.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.android.base.theme.values.AppFontSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val appFontFamily = FontFamily(
    /* Font(R.font.roboto_regular, FontWeight.Normal), //W400
     Font(R.font.roboto_medium, FontWeight.Medium),
     Font(R.font.roboto_bold, FontWeight.Bold),
     Font(R.font.roboto_black, FontWeight.Black)*/
)

open class AppTypography {
    val defaultTypography: androidx.compose.material3.Typography =
        androidx.compose.material3.Typography(
            //   displayLarge = textStyle(AppFontSize.displayLarge)
        )
}

val LocalTypography = staticCompositionLocalOf { appTypography }
val appTypography = AppTypography()

@Preview(showBackground = true)
@Composable
fun AppTypographyPreview() {

    Column(
        Modifier.background(Color.White)
            .padding(16.dp)
            .verticalScroll(ScrollState(0))
    ) {

        Text(text = "displayLarge.", style = appTypography.defaultTypography.displayLarge)
        Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))

        Text(text = "displayMedium. ", style = appTypography.defaultTypography.displayMedium)
        Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))

        Text(text = "displaySmall. ", style = appTypography.defaultTypography.displaySmall)
        Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))

        Text(text = "headlineLarge. ", style = appTypography.defaultTypography.headlineLarge)
        Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))

        Text(text = "headlineSmall. ", style = appTypography.defaultTypography.headlineSmall)
        Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))

        Text(text = "titleLarge. ", style = appTypography.defaultTypography.titleLarge)
        Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))

        Text(text = "titleMedium. ", style = appTypography.defaultTypography.titleMedium)
        Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))

        Text(text = "titleSmall. ", style = appTypography.defaultTypography.titleSmall)
        Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))

        Text(text = "bodyLarge. ", style = appTypography.defaultTypography.bodyLarge)
        Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))

        Text(text = "bodyMedium. ", style = appTypography.defaultTypography.bodyMedium)
        Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))

        Text(text = "bodySmall. ", style = appTypography.defaultTypography.bodySmall)
        Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))

        Text(text = "labelLarge. ", style = appTypography.defaultTypography.labelLarge)
        Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))

        Text(text = "labelMedium. ", style = appTypography.defaultTypography.labelMedium)
        Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))

        Text(text = "labelSmall. ", style = appTypography.defaultTypography.labelSmall)
        Divider(thickness = 1.dp, modifier = Modifier.padding(8.dp))

    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun textStyle(
    appFontSize: AppFontSize,
    fontWeight: FontWeight = FontWeight.Normal
): androidx.compose.ui.text.TextStyle {
    return androidx.compose.ui.text.TextStyle(
        fontFamily = appFontFamily,
        fontSize = appFontSize.size,
        fontWeight = fontWeight,
        lineHeight = appFontSize.lineHeight,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None))
}








