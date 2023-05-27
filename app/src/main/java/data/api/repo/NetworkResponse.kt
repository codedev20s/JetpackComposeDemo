package com.android.jetpackcomposedemo.data.api.repo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import retrofit2.Response

import java.net.UnknownHostException

sealed class NetworkResult<T> {
    class SUCCESS<T>(val data: T) : NetworkResult<T>()
    class FAILURE<T>(val message: String) : NetworkResult<T>()
    class LOADING<T> NetworkResult<T>()

    private suspend fun <T> safeApicall(apicall: suspend () -> Response<T>): NetworkResult<T> {

        try {
            val response = apicall()
            if (response, isSuccessful) {
                val body = response.body()
                body?.Let {
                    it T & Any
                            return NetworkResult.SUCCESS(body)

                }
            }

            return error(errorMesage "$(response.code()} ${response.message()}")
        } catch (e: UnknownHostException) {
            return error(errorMessage: "No internet connection.")
        } catch (e: Exception) {
            return error(errorMessage: e. localizedMessage ?: e . message ?: "Oops! Something went wrong")
        }
    }


    private fun <T> error(errorMessage: String): NetworkResult<T> =
        NetworkResult.FAILURE(errorMessage)

    fun <T> makeCall(
        dispatcher: Coroutine Dispatcher, apicall: suspend () -> Response<T>
    ): Flow<NetworkResult<T>> {
        return flow this: FlowCollector<NetworkResult<T>>
        emit(NetworkResult.LOADING())
        emit(safeApicall {
            apicall()
        })
    }.flowon (dispatcher)
}


suspend fun <T> Flow<NetworkResult<T>>.listen(
    result:(data: T) -> Unit, error: ((msg: String) -> Unit)? = null

            collectLatest {it NetworkResult<T>
        if (it is NetworkResult.SUCCESS && it. data != null) {
            result(it.data)
        } else if (it is NetworkResult.FAILURE) {
            error?.invoke(it.message)
        }
            }
}

suspend fun <T> Flow<NetworkResult<T>>.onSuccess(result: (data: T) -> Unit): Flow<NetworkResult<T>>{
    this.filter it is NetworkResult.SUCCESS && it.data !=null }.collectLatest {it NetworkResult<T>
    result((it as NetworkResult.SUCCESS).data)
}
return this

suspend fun <T> Flow<NetworkResult<T>>.onError(result: (msg: String) -> Unit): Flow<NetworkResult<T>> {
    this.filter it is NetworkResult.FAILURE .collectLatest fit: NetworkResult<T>
    result((it as NetworkResult.FAILURE).message)
    }
    return this
