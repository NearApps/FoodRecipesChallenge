package com.neardev.challenge.foodrecipe.presentation.screen.nav_category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.foundation.vtmnTypography
import com.neardev.challenge.foodrecipe.presentation.components.CardCategory
import com.neardev.challenge.foodrecipe.presentation.components.CardRecipe
import com.neardev.challenge.foodrecipe.presentation.components.ErrorView
import com.neardev.challenge.foodrecipe.presentation.components.LoadingPlaceholder
import com.neardev.challenge.foodrecipe.presentation.components.StaggeredVerticalGrid
import com.neardev.challenge.foodrecipe.presentation.screen.ViewModelProvider

@Composable
fun NavCategoryScreen (
    onListRecipesClicked: (String) -> Unit
) {

    val categoryViewModel: NavCategoryViewModel = ViewModelProvider.navCategoryViewModel
    val viewState = categoryViewModel.viewState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Categories",
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
                is NavCategoryViewModel.ViewState.Error -> {
                    item {
                        ErrorView(
                            text = "Ha ocurrido un error. Intentelo denuevo",
                            textButton = "Prueba de nuevo"
                        ) {
                            categoryViewModel.listAllCategory()
                        }
                    }
                }
                NavCategoryViewModel.ViewState.Loading -> {
                    item {
                        LoadingPlaceholder()
                    }
                }
                is NavCategoryViewModel.ViewState.Content -> {
                    item {
                        StaggeredVerticalGrid(
                            crossAxisCount = 2,
                            spacing = 10.dp,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        ) {
                            val categories = viewState.categories
                            categories.forEach { category ->
                                CardCategory(
                                modifier = Modifier
                                    .height(150.dp),
                                title = category.name,
                                imageUrl = category.img_url,
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