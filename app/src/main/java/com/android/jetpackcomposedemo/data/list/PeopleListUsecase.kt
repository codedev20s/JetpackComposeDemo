package com.android.jetpackcomposedemo.data.list
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject


class PeopleListUseCase @Inject constructor(private val repository: StarWarRepository) :
    NetworkResultUseCase<Unit, PeopleResponse>() {


    override fun execute(param: Unit): Flow<NetworkResult<PeopleResponse>> {
        return repository.getStarWarPeoples()
    }

}