package com.android.jetpackcomposedemo.data.list
import androidx.compose.runtime.State

import androidx.compose.runtime.mutableStateof

import androidx.lifecycle.ViewModel

import com.android.jetpackcomposedemo.data.api.repo.NetworkResult
import com.ascendion.sample.models.PeopleResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest

import javax.inject.Inject

@HiltViewModel
class PeopleListViewModel @Inject constructor( private val useCase: PeopleListUseCase): ViewModel() {

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