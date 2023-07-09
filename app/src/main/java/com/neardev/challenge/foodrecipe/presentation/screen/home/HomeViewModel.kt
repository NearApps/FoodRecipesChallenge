package com.neardev.challenge.foodrecipe.presentation.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {

    var viewState by mutableStateOf<ViewState>(ViewState.Loading)
        private set




    sealed class ViewState {
        object Loading : ViewState()
        data class Error(val throwable: Throwable) : ViewState()
        //data class Content(val episodesWrapper: EpisodesWrapper) : ViewState()
    }
}