package com.android.jetpackcomposedemo.login.data
import com.android.jetpackcomposedemo.data.api.repo.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface LoginRepository {
    fun getLoginDetails(): Flow<NetworkResult<LoginResonse>>
}

class LoginRepositoryImpl @Inject constructor() : LoginRepository {
    override fun getLoginDetails(): Flow<NetworkResult<LoginResonse>> {
        TODO("Not yet implemented")
    }

}