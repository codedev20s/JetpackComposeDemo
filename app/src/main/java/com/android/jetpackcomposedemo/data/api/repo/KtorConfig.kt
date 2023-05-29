package com.android.jetpackcomposedemo.data.api.repo

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.serialization.json.Json

object KtorConfig {
    private const val TIME_OUT = 60_000

    val ktorHttpClient = HttpClient(Android) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })

            engine {
                connectTimeout = TIME_OUT
                socketTimeout = TIME_OUT
            }
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v("Logger Ktor =>", message)
                }
            }
            level = LogLevel.ALL
        }
        install(ResponseObserver) {
            onResponse { response ->
                Log.d("HTTP status:", "msg: ${response.status}")
            }

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
    }


    fun <T> ktorCall(
        dispatcher: CoroutineDispatcher,
        apicall: suspend () -> T
    ): Flow<NetworkResult<T>> {
        return flow {
            emit(NetworkResult.LOADING())
            try {
                emit(NetworkResult.SUCCESS(apicall()))
            } catch (e: Exception) {
                emit(
                    NetworkResult.FAILURE(
                        e.localizedMessage ?: e.message ?: "Oops! Something went wrong."
                    )
                )
            }
        }.flowOn(dispatcher)
    }
}

