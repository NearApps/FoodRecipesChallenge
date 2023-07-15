package com.neardev.challenge.foodrecipe.presentation.screen.nav_ingredient

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.foundation.vtmnTypography
import com.neardev.challenge.foodrecipe.presentation.components.CardIngredient
import com.neardev.challenge.foodrecipe.presentation.components.CardRecipe
import com.neardev.challenge.foodrecipe.presentation.components.StaggeredVerticalGrid
import com.neardev.challenge.foodrecipe.presentation.screen.ViewModelProvider
import com.neardev.challenge.foodrecipe.presentation.screen.nav_category.NavCategoryViewModel

@Composable
fun NavIngredientScreen (
    onListRecipesClicked: (String) -> Unit
) {
    val ingredientViewModel: NavIngredientViewModel = ViewModelProvider.navIngredientViewModel
    val viewState = ingredientViewModel.viewState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Ingredients",
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
                        Text(text = "Error")
                    }
                }
                NavIngredientViewModel.ViewState.Loading -> {
                    item {
                        Text(text = "Loading...")
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