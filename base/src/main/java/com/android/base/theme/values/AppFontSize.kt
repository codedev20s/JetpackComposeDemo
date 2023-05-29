package com.android.base.theme.values

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

enum class AppFontSize(val size:TextUnit, val lineHeight:TextUnit) {
    displayLarge(57.sp,64.sp),
    XXXs(10.sp,13.sp),
    XXS(12.sp,16.sp),
    XS(14.sp,20.sp),
    S(16.sp,24.sp),
    SM(18.sp,28.sp),
    M(20.sp,28.sp),
    L(23.sp,32.sp),
    XL(29.sp,40.sp)
}