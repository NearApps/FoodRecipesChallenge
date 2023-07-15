package com.neardev.challenge.foodrecipe.presentation.screen.nav_ingredient

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neardev.challenge.foodrecipe.di.Main
import com.neardev.challenge.foodrecipe.domain.model.Ingredient
import com.neardev.challenge.foodrecipe.domain.repository.listrecipe.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavIngredientViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
    @Main private val dispatcher: CoroutineDispatcher,
) : ViewModel() {
    var viewState by mutableStateOf<ViewState>(ViewState.Loading)
        private set

    init {
        listAllIngredients()
    }

    fun listAllIngredients() {
        viewModelScope.launch{
            viewState = ViewState.Loading
            recipeRepository.getAllIngredients().fold(
                { failure ->
                    viewState = ViewState.Error(failure)
                },
                { ingredients ->
                    viewState = ViewState.Content(ingredients)
                }
            )
        }
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class Error(val throwable: Throwable) : ViewState()
        data class Content(val ingredients: List<Ingredient>) : ViewState()
    }
}