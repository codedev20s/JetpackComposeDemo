package com.android.jetpackcomposedemo.data.api.repo

import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class KtorApiService @Inject constructor(private val client: HttpClient) {
    suspend fun getStarWarPeoples(): PeopleResponse =
        client.get("https://swapi.dev/api/people")
}