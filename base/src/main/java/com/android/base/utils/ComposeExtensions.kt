package com.android.base.utils

import android.content.res.Resources
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

fun Float.toDp(): Dp {

    return (this / Resources.getSystem().displayMetrics.density).dp
}


fun Dp.toFloat(): Float {

    return value * Resources.getSystem().displayMetrics.density
}


fun Modifier.minLines(

    linCount: Int,

    lineHeight: TextUnit

): Modifier = composed {

    sizeIn(minHeight = with(LocalDensity.current) {
        (lineHeight * linCount).toDp()
    })
}

//@OptIn(ExperimentalGlideComposeApi::class)
@Composable

fun RemoteImage(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    contentDescription: String? = null,
//@DrawableRes placeholder: Int /* R.drawable.ic_placeholder*/,
//@DrawableRes errorPlaceholder: Int /* R.drawable.ic_placeholder*/,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {
    return  /*GlideImage(
        model = imageUrl,
        contentDescription = contentDescription ?: "",
        contentScale = contentScale,
//placeholder = painterResource(placeholder),
//error = painter Resource (errorPlaceholder),
        alignment = alignment,
        alpha = alpha,
        colorFilter = colorFilter,
        modifier = modifier
    )*/
}