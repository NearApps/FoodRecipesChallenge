package com.neardev.challenge.foodrecipe.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.viewmodel.compose.viewModel
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.DetailViewModel
import com.neardev.challenge.foodrecipe.presentation.screen.nav_home.NavHomeViewModel
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.maps.MapsViewModel

object ViewModelProvider {
    val homeViewModel: NavHomeViewModel @Composable get() = localHomeViewModel.current
    val detailViewModel: DetailViewModel @Composable get() = localDetailViewModel.current
    val mapsViewModel: MapsViewModel @Composable get() = localMapsViewModel.current
}

@Composable
fun ProvideMultiViewModel(content: @Composable () -> Unit) {
    val homeViewModel: NavHomeViewModel = viewModel()
    val detailViewModel: DetailViewModel = viewModel()
    val mapsViewModel: MapsViewModel = viewModel()

    CompositionLocalProvider(
        localHomeViewModel provides homeViewModel,
    ) {
        CompositionLocalProvider(
            localDetailViewModel provides detailViewModel,
        ) {
            CompositionLocalProvider(
                localMapsViewModel provides mapsViewModel,
            ) {
                content()
            }
        }
    }
}

private val localHomeViewModel = staticCompositionLocalOf<NavHomeViewModel> { error("No HomeViewModel provided") }
private val localDetailViewModel = staticCompositionLocalOf<DetailViewModel> { error("No DetailViewModel provided") }
private val localMapsViewModel = staticCompositionLocalOf<MapsViewModel> { error("No MapsViewModel provided") }