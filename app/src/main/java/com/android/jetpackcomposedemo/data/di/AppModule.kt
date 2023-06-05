package com.android.jetpackcomposedemo.data.di

import com.android.jetpackcomposedemo.data.api.repo.Constants
import com.android.jetpackcomposedemo.data.api.repo.CoroutinesDispatchersModule
import com.android.jetpackcomposedemo.data.api.repo.KtorConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.features.logging.Logging
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
/*
    @Singleton
    @Provides
    fun provideUserDataSource() = UserDataSource()
*/

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

  /*  @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {

        val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

                OkHttpClient.Builder()
            .addInterceptor(Logging Interceptor)
            .build()

} else {
    OkHttpClient.Builder().build()
}*/

 /*   @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)
 */
    @Provides
    @Singleton
    fun provideCoroutineDispatcher() = CoroutinesDispatchersModule

    @Provides
    @Singleton
    fun provideKtorHttpClient() = KtorConfig.ktorHttpClient
}

   /* @Singleton
    @Provides
    fun provideOkHttpClient() = if (2 == 3*//*BuildConfig.DEBUG*//*) {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

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
*/
