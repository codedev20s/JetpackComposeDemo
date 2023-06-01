package com.android.base.utils

import java.util.Date

fun Long.toFormattedTime(timeFormat:String="dd/MM/yyyy hh:mm a"):String{
    return java.text.SimpleDateFormat(timeFormat, java.util.Locale.US).format(Date(this))
}