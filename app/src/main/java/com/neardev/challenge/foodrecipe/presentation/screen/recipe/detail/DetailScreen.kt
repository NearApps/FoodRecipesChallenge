package com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.neardev.challenge.foodrecipe.domain.model.RecipeDetail
import com.neardev.challenge.foodrecipe.presentation.components.ErrorView
import com.neardev.challenge.foodrecipe.presentation.components.LoadingPlaceholder
import com.neardev.challenge.foodrecipe.presentation.screen.ViewModelProvider
import com.neardev.challenge.foodrecipe.presentation.screen.nav_home.NavHomeViewModel
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.components.TittleRecipe
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.components.InstructionRecipe
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.components.HeaderRecipe
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.components.IngredientsRecipe
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.components.SocialReciper
import com.neardev.challenge.foodrecipe.utilities.openLink

@Composable
fun DetailScreen(
    recipeId: String,
    onMapDetailClicked: ( recipeId: String, latitude: String, longitude: String) -> Unit,
    onBackClicked: () -> Unit,
) {
    val detailViewModel: DetailViewModel = ViewModelProvider.detailViewModel
    val viewState = detailViewModel.viewState

    LaunchedEffect(Unit) {
        detailViewModel.getRecipeDetail(idRecipe = recipeId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ){
        when (viewState) {
            is DetailViewModel.ViewState.Error -> {
                ErrorView(
                    text = "Ha ocurrido un error.",
                    textButton = "Regresar"
                ) {
                    onBackClicked()
                }
            }
            DetailViewModel.ViewState.Loading -> {
                LoadingPlaceholder()
            }
            is DetailViewModel.ViewState.Content -> {
                ContentDetailScreen(
                    recipe = viewState.detail,
                    onMapDetailClicked = {
                        onMapDetailClicked(
                            viewState.detail.id,
                            viewState.detail.latitude,
                            viewState.detail.longitude
                        )
                    },
                )
            }
        }
    }
}

@Composable
fun ContentDetailScreen(
    recipe: RecipeDetail,
    onMapDetailClicked: () -> Unit,
){
    val context = LocalContext.current
    HeaderRecipe(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        imageUrl = recipe.img_url,
        onFavoriteClick = { active ->   },
    )
    Column(
        modifier = Modifier
            .padding(20.dp),
    ) {
        TittleRecipe(
            title = recipe.name,
            rate = recipe.rate,
            comments = recipe.comments,
            onMapDetailClicked = {
                onMapDetailClicked()
            }
        )
        SocialReciper(
            context = context,
            onYoutubeStr = recipe.youtube,
            onShareStr = "",
        )
        IngredientsRecipe(
            modifier = Modifier
                .fillMaxWidth(),
            list_ingredient = recipe.ingredients,
            list_measure = recipe.cants,
        )
        Spacer(modifier = Modifier.height(10.dp))
        InstructionRecipe(
            modifier = Modifier
                .fillMaxWidth(),
            description = recipe.instruccions
        )
        //Spacer(modifier = Modifier.height(10.dp))
    }
}