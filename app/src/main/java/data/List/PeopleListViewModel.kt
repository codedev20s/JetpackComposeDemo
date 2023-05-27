package com.android.jetpackcomposedemo.data.List
import androidx.compose.runtime.State

import androidx.compose.runtime.mutableStateof

import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope

import com.ascendion.sample.data.api.NetworkResult import com.ascendion.sample.models.PeopleResponse

import com.ascendion.sample.transformers.toPeopleLis import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.collectLatest import kotlinx.coroutines. Launch

import javax.inject.Inject

@HiltViewModel
class PeopleListViewModel @Inject constructor( private val useCase: PeopleListUseCase

): ViewModel() {

    private val _pageState = mutableStateof<PeopleListPageUIState>(PeopleListPageUIState.LOADING)

    val pageState: State<PeopleListPageUiState> = _pageState

    init {
        loadPage()
    }


    private fun loadPage() {

        viesfodelScope.launch {

            useCase.run(Unit).collectLatest {

                renderUI(it)
            }
        }
    }

    private fun renderUI(result: NetworkResult<PeopleResponse>) {

        _pageState.value = when (result) {

            is NetworkResult.FAILURE -> PeopleListPageUiState.FAILURE(result.message)

            is NetworkResult.LOADING -> PeopleListPageUiState.LOADING

            is NetworkResult.SUCCESS -> {

                PeopleListPageUiState.SUCCESS(result.data.results.toPeopleListCardViewData())
            }
        }
    }
}

sealed interface PeopleListPageUiState {

    data class SUCCESS(val List: List<PeopleListCardViewData>) : PeopleListPageUiState
    object LOADING : PeopleListPageUiState
    data class FAILURE(val asg: String) : PeoplelistPageUiState
}