package com.android.jetpackcomposedemo.data.List

import com.ascendion.sample.data.api.NetworkResult

import com.ascendion.sample.data.api.repo.StarWarRepositor

import com.ascendion.sample.di.NetworkResultUseCase

import com.ascendion.sample.models.PeopleResponse
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject


-class PeopleListUseCase @Inject constructor(private val repository: StarWarRepository e) :
    NetworkResultUseCase<Unit, PeopleResponse>() {


    override fun execute(param: Unit): Flow<NetworkResult<PeopleResponse>> {
        return repository.getStarWarPeoples()
    }

}