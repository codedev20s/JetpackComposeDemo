package com.android.base.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.android.base.R
import com.android.base.theme.values.AppFontSize


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

val LocalTypography = staticCompositionLocalOf { appTypography   }
val appTypography = AppTypography()



