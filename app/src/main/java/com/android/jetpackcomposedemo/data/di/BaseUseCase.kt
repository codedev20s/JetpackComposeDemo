package com.android.jetpackcomposedemo.data.di

import com.android.jetpackcomposedemo.data.api.repo.NetworkResult
import kotlinx.coroutines.flow.Flow

abstract class NetworkResultUseCase<in P, R> {
    fun run(param: P): Flow<NetworkResult<R>> = execute(param)

    protected abstract fun execute(param: P): Flow<NetworkResult<R>>
}

abstract class FlowUseCase<in P, R> {
    fun run(param: P): Flow<R> = execute(param)

    protected abstract fun execute(param: P): Flow<R>
}

abstract class SuspendUseCase<in P> {
    suspend fun run(param: P) = execute(param)

    protected abstract suspend fun execute(param: P)
}