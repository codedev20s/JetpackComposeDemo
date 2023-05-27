package com.android.jetpackcomposedemo.data.api.repo

import com.ascendion.sample.models. PeopleResponse
import com.ascendion.sample.models.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface ApiService {
            @GET("users")
            suspend fun getUsers(): Response<List<User>>

            @GET()

    suspend fun getStarWarPeoples (@Url url: String = "https://swapi.dev/api/people"): Response<PeopleResponse>