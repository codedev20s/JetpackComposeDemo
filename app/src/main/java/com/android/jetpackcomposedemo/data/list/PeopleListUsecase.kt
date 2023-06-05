/*
package com.android.jetpackcomposedemo.data.list
import com.android.jetpackcomposedemo.data.api.repo.NetworkResult
import com.android.jetpackcomposedemo.data.api.repo.PeopleResponse
import com.android.jetpackcomposedemo.data.di.NetworkResultUseCase
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject


class PeopleListUseCase @Inject constructor(private val repository: StarWarRepository) :
    NetworkResultUseCase<Unit, PeopleResponse>() {


    override fun execute(param: Unit): Flow<NetworkResult<PeopleResponse>> {
        return repository.getStarWarPeoples()
    }

}*/
