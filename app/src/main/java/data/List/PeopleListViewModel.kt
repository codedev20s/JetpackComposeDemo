package com.android.jetpackcomposedemo.data.List
import androidx.compose.runtime.State

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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
    data class SUCCESS(val list: List<PeopleListCardViewData>) : PeopleListPageUiState
    object LOADING : PeopleListPageUiState
    data class FAILURE(val msg: String) : PeopleListPageUiState
}