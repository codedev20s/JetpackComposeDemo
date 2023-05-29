package com.android.base.theme.values

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Immutable
class AppShapes(
    val material: Shapes = Shapes(),
    val AppCustomShapes: AppCustomElevations = AppCustomElevations()
)

@Immutable
open class AppCustomShapes(
    val topStartBottomRoundedCorner: Shape = shapeTopStartBottomEndRoundedCorner
)

val LocalAppShapes by lazy { staticCompositionLocalOf { defaultShapes } }
val defaultShapes by lazy { AppShapes() }

private val shapeTopStartBottomEndRoundedCorner: Shape = RoundedCornerShape(
    topStart = 4.dp,
    bottomEnd = 4.dp
)
