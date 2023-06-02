package com.android.jetpackcomposedemo.login.data
import com.android.jetpackcomposedemo.data.api.repo.KtorApiHelper
import com.android.jetpackcomposedemo.data.api.repo.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface LoginRepository {
    fun getLoginDetails(loginRequest:LoginRequest): Flow<NetworkResult<LoginResonse>>
}

class LoginRepositoryImpl @Inject constructor(private val ktorApiHelper: KtorApiHelper) : LoginRepository {
    override fun getLoginDetails(loginRequest:LoginRequest): Flow<NetworkResult<LoginResonse>> {
      return  ktorApiHelper.getLoginUserDetails(loginRequest)
    }
}