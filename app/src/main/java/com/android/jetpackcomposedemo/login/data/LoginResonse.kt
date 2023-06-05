package com.android.jetpackcomposedemo.login.data

import kotlinx.serialization.Serializable

@Serializable
data class LoginResonse(
    val email: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val username: String
)