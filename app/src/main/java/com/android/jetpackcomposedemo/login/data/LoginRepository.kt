package com.android.jetpackcomposedemo.login.data

import javax.inject.Inject


interface LoginRepository {
    fun getLoginDetails()
}

class LoginRepositoryImpl @Inject constructor() : LoginRepository {

    val xyz="AJAY"
    override fun getLoginDetails() {

    }

}