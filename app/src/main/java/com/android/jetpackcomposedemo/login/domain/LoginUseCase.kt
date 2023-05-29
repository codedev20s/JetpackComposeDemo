package com.android.jetpackcomposedemo.login.domain

import com.android.jetpackcomposedemo.data.api.repo.NetworkResult
import com.android.jetpackcomposedemo.data.api.repo.PeopleResponse
import com.android.jetpackcomposedemo.data.di.NetworkResultUseCase
import com.android.jetpackcomposedemo.login.data.LoginRepository
import com.android.jetpackcomposedemo.login.data.LoginRequest
import com.android.jetpackcomposedemo.login.data.LoginResonse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) :
    NetworkResultUseCase<LoginRequest, LoginResonse>() {
    override fun execute(param: LoginRequest): Flow<NetworkResult<LoginResonse>> {
        return repository.getLoginDetails()
    }
}