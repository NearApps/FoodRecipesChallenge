package com.neardev.challenge.foodrecipe.presentation.screen.nav_home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.foundation.vtmnTypography
import com.neardev.challenge.foodrecipe.domain.utilities.Constants.Companion.SEARCH_DELAY
import com.neardev.challenge.foodrecipe.presentation.components.CardRecipe
import com.neardev.challenge.foodrecipe.presentation.components.EmptyView
import com.neardev.challenge.foodrecipe.presentation.components.ErrorView
import com.neardev.challenge.foodrecipe.presentation.components.HomeBarSearch
import com.neardev.challenge.foodrecipe.presentation.components.LoadingPlaceholder
import com.neardev.challenge.foodrecipe.presentation.components.StaggeredVerticalGrid
import com.neardev.challenge.foodrecipe.presentation.screen.ViewModelProvider
import com.neardev.challenge.foodrecipe.utilities.extension.text.normalizeText
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun NavHomeScreen(
    onDetailClicked: (String) -> Unit
) {

    val context = LocalContext.current

    val homeViewModel: NavHomeViewModel = ViewModelProvider.homeViewModel
    val viewState = homeViewModel.viewState

    val searching = remember { mutableStateOf(EMPTY_SEARCH) }
    //val loading = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        homeViewModel.searchFilter()
        homeViewModel.viewEventFlow.collect { viewEvent ->
            when (viewEvent) {
                is NavHomeViewModel.ViewEvent.NavigateToDetail -> onDetailClicked(viewEvent.idRecipe)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        HomeBarSearch(
            onChangeListener = { str ->
                searching.value = str
                MainScope().launch {
                    delay(SEARCH_DELAY)
                    homeViewModel.searchFilter(searching.value)
                }
            },
            onClickClose = {
                searching.value = EMPTY_SEARCH
                homeViewModel.searchFilter()
            },
        )

        Text(
            text = if (searching.value.isEmpty()) { "All recipes" } else { "Searching for \"${searching.value}\"" },
            color = VitaminTheme.colors.vtmnContentSecondary,
            style = vtmnTypography.h6,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier.fillMaxSize()
        ) {
            when (viewState) {
                is NavHomeViewModel.ViewState.Loading -> {
                    item {
                        LoadingPlaceholder()
                    }
                }
                is NavHomeViewModel.ViewState.Error -> {
                    item {
                        ErrorView(
                            text = "Ha ocurrido un error. Intentelo denuevo",
                            textButton = "Prueba de nuevo"
                        ) {
                            homeViewModel.searchFilter()
                        }
                    }
                }
                is NavHomeViewModel.ViewState.NotFound -> {
                    item {
                        EmptyView(
                            text = "No se encontro resultados",
                            textButton = "Limpiar"
                        ) {
                            searching.value = EMPTY_SEARCH
                            homeViewModel.searchFilter()
                        }
                    }
                }
                is NavHomeViewModel.ViewState.Content -> {
                    item {
                        StaggeredVerticalGrid(
                            crossAxisCount = 2,
                            spacing = 10.dp,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        ) {
                            val recipes = viewState.recipes
                            /*val filterRecipers = if(searching.value.isBlank()){
                                recipes
                            }else{
                                recipes.filter { recipe ->
                                    val lowerCaseTitle = recipe.name.normalizeText()
                                    val lowerSearchText = searching.value.normalizeText()
                                    lowerCaseTitle.contains(lowerSearchText)
                                }
                            }*/

                            /*filterRecipers.*/recipes.forEach { recipe ->
                            CardRecipe(
                                modifier = Modifier
                                    .height(150.dp),
                                title = recipe.name,
                                imageUrl = recipe.img_url,
                                onClick = { onDetailClicked(recipe.id) }
                            )
                        }
                        }
                    }
                }
            }
        }
    }
}

private const val EMPTY_SEARCH = ""