package com.android.jetpackcomposedemo.data.api.repo

import com.android.jetpackcomposedemo.data.api.repo.KtorConfig.ktorCall
import com.android.jetpackcomposedemo.login.data.LoginRequest
import com.android.jetpackcomposedemo.login.data.LoginResonse
import kotlinx.coroutines.CoroutineDispatcher

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class KtorApiHelper @Inject constructor(
    private val userApi: KtorApiService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher) {

    fun getLoginUserDetails(loginRequest:LoginRequest) : Flow<NetworkResult<LoginResonse>>{
        return ktorCall(dispatcher) { userApi.getLoginResponse(loginRequest)}
    }

}