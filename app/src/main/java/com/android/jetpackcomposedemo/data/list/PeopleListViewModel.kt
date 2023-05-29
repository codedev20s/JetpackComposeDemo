/*
package com.android.jetpackcomposedemo.data.list
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.jetpackcomposedemo.data.api.repo.NetworkResult
import com.android.jetpackcomposedemo.data.api.repo.PeopleResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleListViewModel @Inject constructor( private val useCase: PeopleListUseCase

): ViewModel() {

    private val _pageState = mutableStateOf<PeopleListPageUIState>(PeopleListPageUIState.LOADING)

    val pageState: State<PeopleListPageUiState> = _pageState

    init {
        loadPage()
    }


    private fun loadPage() {
        viewModelScope.launch {
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
}*/
