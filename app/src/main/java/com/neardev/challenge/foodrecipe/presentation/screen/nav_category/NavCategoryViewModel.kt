package com.neardev.challenge.foodrecipe.presentation.screen.nav_category

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neardev.challenge.foodrecipe.di.Main
import com.neardev.challenge.foodrecipe.domain.model.Category
import com.neardev.challenge.foodrecipe.domain.repository.listrecipe.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavCategoryViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
    @Main private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    var viewState by mutableStateOf<ViewState>(ViewState.Loading)
        private set

    init {
        //listAllCategory()
    }

    fun listAllCategory() {
        viewModelScope.launch{
            viewState = ViewState.Loading
            recipeRepository.getAllCategories().fold(
                { failure ->
                    viewState = ViewState.Error(failure)
                },
                { categories ->
                    viewState = ViewState.Content(categories)
                }
            )
        }
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class Error(val throwable: Throwable) : ViewState()
        data class Content(val categories: List<Category>) : ViewState()
    }
}