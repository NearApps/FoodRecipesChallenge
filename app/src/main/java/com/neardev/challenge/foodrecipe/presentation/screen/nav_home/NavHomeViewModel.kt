package com.neardev.challenge.foodrecipe.presentation.screen.nav_home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neardev.challenge.foodrecipe.di.Main
import com.neardev.challenge.foodrecipe.domain.model.Recipe
import com.neardev.challenge.foodrecipe.domain.repository.listrecipe.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavHomeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
    @Main private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    var viewState by mutableStateOf<ViewState>(ViewState.Loading)
        private set

    private val _viewEventFlow = MutableSharedFlow<ViewEvent>()
    val viewEventFlow = _viewEventFlow.asSharedFlow()

    init {
        searchFilter("a")
    }

    fun searchFilter(search: String) {
        viewModelScope.launch{
            viewState = ViewState.Loading
            recipeRepository.getFilterByName(search).fold(
                { failure ->
                    viewState = ViewState.Error(failure)
                },
                { recipes ->
                    if (recipes.isEmpty()){
                        viewState = ViewState.NotFound(search)
                    }else{
                        viewState = ViewState.Content(recipes)
                    }
                }
            )
        }
    }

    sealed class ViewEvent {
        data class NavigateToDetail(
            val idRecipe: String
        ) : ViewEvent()
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class Error(val throwable: Throwable) : ViewState()
        data class NotFound(val search: String) : ViewState()
        data class Content(val recipes: List<Recipe>) : ViewState()
    }
}