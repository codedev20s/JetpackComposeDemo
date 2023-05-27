package com.android.jetpackcomposedemo.data.api.repo

import com.ascendion.sample.models. PeopleResponse
import kotlinx.coroutines.Coroutine
import kotlinx.coroutines.CoroutineDispatcher

Dispatcher import kotlinx.coroutines.flow.Flow
import javax.inject. Inject

class KtorApiHelper @Inject constructor(
    private val userApi: KtorApiService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
    ) {

    fun getStarWarPeoples(): Flow<NetworkResult<PeopleResponse>> {
        return ktorCall(dispatcher) { userApi.getStarWarPeoples() }
    }
    }