package com.android.base.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.android.base.theme.values.AppColor
import com.android.base.theme.values.AppElevations
import com.android.base.theme.values.AppShapes
import com.android.base.theme.values.LocalAppColors
import com.android.base.theme.values.LocalAppElevations
import com.android.base.theme.values.LocalAppShapes
import com.android.base.theme.values.defaultAppColors
import com.android.base.theme.values.defaultElevations
import com.android.base.theme.values.defaultShapes
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun BaseAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: AppColor = defaultAppColors,
    typography: AppTypography = appTypography,
    shapes: AppShapes = defaultShapes,
    elevation: AppElevations = defaultElevations,
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    if (darkTheme) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = Color.White
        )
    }

    CompositionLocalProvider(
        LocalAppColors provides defaultAppColors,
        LocalTypography provides typography,
        LocalAppShapes provides shapes,
        LocalAppElevations provides elevation) {
        MaterialTheme(
            //colorScheme = defaultAppColors.scheme(darkTheme),
            typography = typography.defaultTypography,
            shapes = shapes.material,
            content = content)
    }
}

object BaseTheme{

    val colors:AppColors
    @Composable
    get()=LocalAppColors.current

    val typography:AppTypography
        @Composable
        get()=LocalTypography.current

    val shapes:AppShapes
        @Composable
        get()=LocalAppShapes.current

    val elevations:AppElevations
        @Composable
        get()=LocalAppElevations.current
}