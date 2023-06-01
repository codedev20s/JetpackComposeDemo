package com.android.jetpackcomposedemo.login.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.jetpackcomposedemo.data.api.repo.NetworkResult
import com.android.jetpackcomposedemo.login.data.LoginRequest
import com.android.jetpackcomposedemo.login.data.LoginResonse
import com.android.jetpackcomposedemo.login.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val useCase: LoginUseCase): ViewModel() {

    private val _pageState = mutableStateOf<LoginPageUiState>(LoginPageUiState.DONothing)
    val pageState: State<LoginPageUiState> = _pageState

     fun callLoginAPI(userName:String,password:String) {
        val loginRequest= LoginRequest(userName,password)
        viewModelScope.launch {
            useCase.run(loginRequest).collectLatest {
                renderUI(it)
            }
        }
    }

    private fun renderUI(result: NetworkResult<LoginResonse>) {
        _pageState.value = when (result) {
            is NetworkResult.FAILURE -> LoginPageUiState.FAILURE(result.message)
            is NetworkResult.LOADING -> LoginPageUiState.LOADING
            is NetworkResult.SUCCESS -> {
                LoginPageUiState.SUCCESS(result.data)
            }
        }
    }
}

sealed interface LoginPageUiState {
    data class SUCCESS(val userResponse: LoginResonse) : LoginPageUiState
    object LOADING : LoginPageUiState
    data class FAILURE(val msg: String) : LoginPageUiState
    object DONothing:LoginPageUiState
}