package com.android.jetpackcomposedemo.data.di

import com.android.jetpackcomposedemo.data.api.repo.KtorConfig
import com.ascendion.sample.BuildConfig

import com.ascendion.sample.data.api.ApiService

import com.ascendion.sample.data.api.Constants

import com.ascendion.sample.data.api.CoroutinesDispatche

import com.ascendion.sample.data.api.KtorConfig

import com.ascendion.sample.data.api.repo.UserDataSource
import dagger.Module

import dagger.Provides

import dagger.hilt.Installin

import dagger.hilt.components.SingletonComponent

import okhttp3

.0kHttpClient


import okhttp3.Logging.HttpLogging

Interceptor import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {
    @singleton
    @Provides
    fun provideUserDataSource() UserDataSource()

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {

        val loggingInterceptor =
            HttpLoggingInterceptor() LoggingInterceptor . setLevel (HttpLogging Interceptor . Level . BODY)

        OkHttpClient.Builder()
            .addInterceptor(Logging Interceptor)
            .build()

    } else {
        OkHttpClient.Builder().build()
    }

    @singleton
    @Provides

    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(
            GsonConverterFactory.create
                .baseUrl(BASE_URL)
                .client(okttClient)
                .build()


            @Provides
            @Singleton

            fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

            @Provides
            @singleton
            fun provideCoroutineDispatcher() = CoroutinesDispatchersModule

             @Provides
            @singleton
            fun provideKtorHttpClient() = KtorConfig.ktorHttpClient

