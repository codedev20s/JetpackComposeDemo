package com.android.jetpackcomposedemo.data.api.repo

import kotlinx.coroutines.CoroutineDispatcher
import javax.inject. Inject

class ApiHelper @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
    fun getUsers() = makeCall(dispatcher) { apiservice.getUsers() }

    fun getStarWarPeoples() = makeCall(dispatcher) { apiService.getStarWarPeoples() }
}

