package com.android.jetpackcomposedemo.data.api.repo

import android.util.Log
import io.ktor.client.
import io.ktor.client.engine.android. import io.ktor.client.features.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.* import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.* import io.ktor.client.request.* import io.ktor.http.*
import kotlinx.coroutines.Coroutine Dispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow import kotlinx.coroutines. flow. flowon
import kotlinx.serialization.json.Json

object KtorConfig {
    private const val TIME OUT = 60_000
    val ktorHttpClient = HttpClient(Android) { this HttpClientConfig<AndroidEngineConfig>

        install(JsonFeature) {
            this: JsonFeature.Config
            serializer = KotlinxSerializer(Json {
                this.JsonBuilder
                prettyPrint = true
                islenient = true
                ignoreUnknownkeys = true
            })

            engine {
                this AndroidEngineConfig
                        connectTimeout = TIME OUT
                        socketTimeout = TIME OUT
            }
        }

        install(Logging) {
            this Logging . Config
                    Logger = object : Logger {
                override fun Log(message: String) {
                    Log.v(tag"Logger Ktor =>", message)
                }
            }
            level = Loglevel.All
        }

        install (Response0bserver) { this: ResponseObserver.Config
            onResponse { response ->
                Log.d( tag: "HTTP status:", msg: "${response.statu

                }
            }

            install (DefaultRequest) {
                this:HttpRequestBuilder
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
    }
            //fun Exception.toCustomExceptions() = when (this) { .../

            fun <T> ktorCall(
                dispatcher: Coroutine Dispatcher, apicall: :suspend () -> T
    ):Flow<NetworkResult<T>> {
        return flow this: FlowCollectors NetworkResult<T>>
        emit (NetworkResult.LOADING())
        try {
            emit (NetworkResult.SUCCESS (apicall()))
        } catch (e: Exception) {
            emit(
                NetworkResult.FAILURE(
                    e.LocalizedMessage ?: e.message ?:"Oops! Something went wrong."
                )
            )
        }
    }.flowOn(dispatcher)
}

