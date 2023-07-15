package com.neardev.challenge.foodrecipe.presentation.screen.nav_ingredient

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.foundation.vtmnTypography
import com.neardev.challenge.foodrecipe.presentation.components.CardIngredient
import com.neardev.challenge.foodrecipe.presentation.components.CardRecipe
import com.neardev.challenge.foodrecipe.presentation.components.ErrorView
import com.neardev.challenge.foodrecipe.presentation.components.LoadingPlaceholder
import com.neardev.challenge.foodrecipe.presentation.components.StaggeredVerticalGrid
import com.neardev.challenge.foodrecipe.presentation.screen.ViewModelProvider
import com.neardev.challenge.foodrecipe.presentation.screen.nav_category.NavCategoryViewModel

@Composable
fun NavIngredientScreen (
    onListRecipesClicked: (String) -> Unit
) {
    val ingredientViewModel: NavIngredientViewModel = ViewModelProvider.navIngredientViewModel
    val viewState = ingredientViewModel.viewState

    var showLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        ingredientViewModel.listAllIngredients()
        ingredientViewModel.viewEventFlow.collect { viewEvent ->
            when (viewEvent) {
                NavIngredientViewModel.ViewEvent.HideLoading -> showLoading = false
                NavIngredientViewModel.ViewEvent.ShowLoading -> showLoading = true
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "All ingredients",
            color = VitaminTheme.colors.vtmnContentSecondary,
            style = vtmnTypography.h6,
            textAlign = TextAlign.Center,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier
                .fillMaxSize()
        ) {
            when(viewState){
                is NavIngredientViewModel.ViewState.Error -> {
                    item {
                        ErrorView(
                            text = "Ha ocurrido un error. Intentelo denuevo",
                            textButton = "Prueba de nuevo"
                        ) {
                            ingredientViewModel.listAllIngredients()
                        }
                    }
                }
                NavIngredientViewModel.ViewState.Loading -> {
                    item {
                        LoadingPlaceholder()
                    }
                }
                is NavIngredientViewModel.ViewState.Content -> {
                    item {
                        StaggeredVerticalGrid(
                            crossAxisCount = 2,
                            spacing = 10.dp,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        ) {
                            val ingredients = viewState.ingredients
                            ingredients.forEach { ingredient ->
                                CardIngredient(
                                    modifier = Modifier
                                        .height(100.dp),
                                    title = ingredient.name,
                                    onClick = {}
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}