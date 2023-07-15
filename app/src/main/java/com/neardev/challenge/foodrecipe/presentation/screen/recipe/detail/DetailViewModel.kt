package com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.neardev.challenge.foodrecipe.di.Main
import com.neardev.challenge.foodrecipe.domain.model.RecipeDetail
import com.neardev.challenge.foodrecipe.domain.repository.listrecipe.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
    @Main private val dispatcher: CoroutineDispatcher,
) : ViewModel() {
    var viewState by mutableStateOf<ViewState>(ViewState.Loading)
        private set

    private val _viewEventFlow = MutableSharedFlow<ViewEvent>()
    val viewEventFlow = _viewEventFlow.asSharedFlow()

    fun getRecipeDetail(idRecipe: String) {
        viewModelScope.launch{
            viewState = ViewState.Loading
            recipeRepository.getRecipeById(idRecipe).fold(
                { failure ->
                    viewState = ViewState.Error(failure)
                },
                { recipe ->
                    viewState = ViewState.Content(recipe)
                }
            )
        }
    }

    sealed class ViewEvent {
        data class NavigateToMap(
            val idRecipe: String,
            val latitude: String,
            val longitude: String
        ) : ViewEvent()
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class Error(val throwable: Throwable) : ViewState()
        data class Content(val detail: RecipeDetail) : ViewState()
    }
}