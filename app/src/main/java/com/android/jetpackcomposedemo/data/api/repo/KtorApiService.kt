package com.android.jetpackcomposedemo.data.api.repo

import com.android.jetpackcomposedemo.login.data.LoginRequest
import com.android.jetpackcomposedemo.login.data.LoginResonse
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class KtorApiService @Inject constructor(private val client: HttpClient) {
    suspend fun getLoginResponse(loginRequest: LoginRequest): LoginResonse =
        client.post("https://run.mocky.io/v3/fe2f8593-bd7d-4ab1-aa90-69815d2dbc6c"){
        }
}