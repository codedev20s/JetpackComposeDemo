package com.android.base.theme.values

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
open class AppElevations(
    val customElevations: AppCustomElevations = AppCustomElevations()
)

@Immutable
open class AppCustomElevations(val appBar: Dp = 0.dp, val actionButton: Dp = 0.dp)

val LocalAppElevations = staticCompositionLocalOf { defaultElevations }

val defaultElevations = AppElevations()