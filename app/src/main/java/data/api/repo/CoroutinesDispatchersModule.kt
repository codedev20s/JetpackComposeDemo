package com.android.jetpackcomposedemo.data.api.repo

import dagger.Module
import dagger.Provides
import dagger.hilt. Installin
import dagger.hilt.components. SingletonComponent
import kotlinx.coroutines.Coroutine
import kotlinx.coroutines.CoroutineDispatcher

Dispatcher import kotlinx.coroutines. Dispatchers

@InstallIn(SingletonComponent::class)
@Module
object CoroutinesDispatchersModule {
    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers. 10

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main