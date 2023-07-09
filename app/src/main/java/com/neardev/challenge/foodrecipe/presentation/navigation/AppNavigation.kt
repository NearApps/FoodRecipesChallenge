package com.neardev.challenge.foodrecipe.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.neardev.challenge.foodrecipe.core.common.KLog
import com.neardev.challenge.foodrecipe.presentation.AppState
import com.neardev.challenge.foodrecipe.presentation.screen.detail.DetailScreen
import com.neardev.challenge.foodrecipe.presentation.screen.home.HomeScreen
import com.neardev.challenge.foodrecipe.presentation.screen.maps.MapsScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    appState: AppState,
) {
    NavHost(
        navController = navController,
        startDestination = NavCommand.Home().createRoute()
    ) {
        composable(
            navCommand = NavCommand.Home()
        ) {
            //appState.setStartDestination(Feature.FREE)
            HomeScreen(
                onDetailClicked = { recipeId ->
                    navController.navigate(
                        route = NavCommand.ContentDetail(listOf(NavArg.RecipeId)).createRoute(recipeId)
                    )
                },
            )
        }

        composable(
            navCommand = NavCommand.ContentDetail(listOf(NavArg.RecipeId))
        ) {
            DetailScreen(
                recipeId = it.findArg(NavArg.RecipeId),
                onMapDetailClicked = { recipeId, latitude, longitude ->
                    navController.navigate(
                        route = NavCommand
                            .ContentMapRecipe(listOf(NavArg.RecipeId, NavArg.Latitude, NavArg.Longitude))
                            .createRoute(recipeId, latitude, longitude)
                    )
                },
                onBackClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            navCommand = NavCommand.ContentMapRecipe(listOf(NavArg.RecipeId, NavArg.Latitude, NavArg.Longitude))
        ) {
            MapsScreen(
                recipeId = it.findArg(NavArg.RecipeId),
                latitude = it.findArg(NavArg.Latitude),
                longitude = it.findArg(NavArg.Longitude),
                onBackClicked = {
                    navController.popBackStack()
                }
            )
        }
    }
}


private fun NavGraphBuilder.composable(
    navCommand: NavCommand,
    content: @Composable (NavBackStackEntry) -> Unit,
) {
    KLog.e("Route --------> " + navCommand.route)
    composable(
        route = navCommand.route,
        arguments = navCommand.args
    ) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(arg: NavArg): T {
    val value = arguments?.get(arg.key)
    requireNotNull(value)
    return value as T
}