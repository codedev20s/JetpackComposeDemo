package com.android.base.theme.values

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


object AppColor {
    val colorTeal = Color(0xff08fac2)
    val colorDarkTeal = Color(0xFF008567)
    val colorYellow = Color(0xFFFFCC00)
    val colorPurple = Color(0xFF6666CC)
    val colorPink = Color(0xFFCC0066)
    val colorLightGrey = Color(0xFFafaab9)
    val colorDarkGrey = Color(0xFF71758a)
    val whilteColor = Color(0xFFFFEB35)
}

@Immutable
class AppColorPaletteLight(
    val primary: Color = Color(0xFF675884),
    val secondary: Color = Color(0xFF625b71),
    val tertiary: Color = Color(0xFF7e5268)
)

@Immutable
open class AppColorPaletteDark(
    val primary: Color = Color(0xFFcfbcff),
    val secondary: Color = Color(0xFFcbc2db),
    val tertiary: Color = Color(0xFFefb8c8)
)

val defaultAppColors by lazy { AppColor }

val oppColorPalettelight by lazy { AppColorPaletteLight() }

val appColorPaletteDark by lazy { AppColorPaletteDark() }

val LocalAppColors =staticCompositionLocalOf{defaultAppColors}


private val DarkColors = darkColorScheme(
    primary = appColorPaletteDark.primary,
    onPrimary = Color(0xFF381e72),
    primaryContainer = Color(0xFF4f378a),
    onPrimaryContainer = Color(0xFFe9ddff),
    secondary = appColorPaletteDark.secondary,
    onSecondary = Color(0xFF332d41),
    secondaryContainer = Color(0xFF4a4458),
    onSecondaryContainer = Color(0xFFe8def8),
    tertiary = appColorPaletteDark.tertiary,
    onTertiary = Color(0xFF4a2532),
    tertiaryContainer = Color(0xFF633b48),
    onTertiaryContainer = Color(0xFFffd9e3),
    error = Color(0xFFffb4ab),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93008a),
    onErrorContainer = Color(0xFFFfdad6),
    background = Color(0xFF1c1b1e),
    onBackground = Color(0xFFe6e1e6),
    surface = Color(0xFF1c1b1e),
    onSurface = Color(0xFFe6e1e6),
    outline = Color(0xFF948f99),
    surfaceVariant = Color(0xFF49454e),
    onSurfaceVariant = Color(0xFFcac4cf)
)


private val LightColors = lightColorScheme(
    primary = appColorPaletteDark.primary,
    onPrimary = Color(0xFF381e72),
    primaryContainer = Color(0xFF4f378a),
    onPrimaryContainer = Color(0xFFe9ddff),
    secondary = appColorPaletteDark.secondary,
    onSecondary = Color(0xFF332d41),
    secondaryContainer = Color(0xFF4a4458),
    onSecondaryContainer = Color(0xFFe8def8),
    tertiary = appColorPaletteDark.tertiary,
    onTertiary = Color(0xFF4a2532),
    tertiaryContainer = Color(0xFF633b48),
    onTertiaryContainer = Color(0xFFffd9e3),
    error = Color(0xFFffb4ab),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93008a),
    onErrorContainer = Color(0xFFFfdad6),
    background = Color(0xFF1c1b1e),
    onBackground = Color(0xFFe6e1e6),
    surface = Color(0xFF1c1b1e),
    onSurface = Color(0xFFe6e1e6),
    outline = Color(0xFF948f99),
    surfaceVariant = Color(0xFF49454e),
    onSurfaceVariant = Color(0xFFcac4cf)
)

open class AppColors
    (
    val lightScheme: ColorScheme = LightColors,
    val darkScheme: ColorScheme = DarkColors,
    val colorPalettelight: AppColorPaletteLight = oppColorPalettelight,
    val colorPaletteDark: AppColorPaletteDark = appColorPaletteDark
) {

    fun scheme(isDark: Boolean): ColorScheme {
        return if (isDark)
            darkScheme
        else lightScheme
    }
}