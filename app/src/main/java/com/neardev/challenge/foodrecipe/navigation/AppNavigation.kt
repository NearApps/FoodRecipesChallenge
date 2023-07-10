package com.neardev.challenge.foodrecipe.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.neardev.challenge.foodrecipe.presentation.AppState
import com.neardev.challenge.foodrecipe.presentation.screen.nav_area.NavAreaScreen
import com.neardev.challenge.foodrecipe.presentation.screen.nav_category.NavCategoryScreen
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.DetailScreen
import com.neardev.challenge.foodrecipe.presentation.screen.nav_home.NavHomeScreen
import com.neardev.challenge.foodrecipe.presentation.screen.nav_ingredient.NavIngredientScreen
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.list.ListScreen
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.maps.MapsScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    appState: AppState,
) {
    NavHost(
        navController = navController,
        startDestination = NavItemHome.HOME.route
    ) {

        /*****************************************************
         *                 NAV SCREEN                        *
         *****************************************************/
        composable(route = NavItemHome.HOME.route) {
            NavHomeScreen(
                onDetailClicked = { recipeId -> navController.navigate( route = "recipe/$recipeId") },
            )
        }
        composable(route = NavItemHome.CATEGORY.route) {
            NavCategoryScreen(
                onListRecipesClicked = { type -> navController.navigate( route = "list/$type") },
            )
        }
        composable(route = NavItemHome.INGREDIENTS.route) {
            NavIngredientScreen(
                onListRecipesClicked = { type -> navController.navigate( route = "list/$type") },
            )
        }
        composable(route = NavItemHome.AREA.route) {
            NavAreaScreen(
                onListRecipesClicked = { type -> navController.navigate( route = "list/$type") },
            )
        }

        /*****************************************************
         *                 RECIPE SCREEN                     *
         *****************************************************/
        composable(
            route = "list/{type}",
            arguments = listOf(navArgument("type") {type=NavType.StringType})
        ) {
            ListScreen(
                type = it.arguments?.getString("type") ?: "",
                onDetailClicked = { recipeId -> navController.navigate( route = "recipe/$recipeId") },
                onBackClicked = { navController.goBack() },
            )
        }
        composable(
            route = "recipe/{recipeId}",
            arguments = listOf(navArgument("recipeId") {type=NavType.StringType})
        ) {
            DetailScreen(
                recipeId = it.arguments?.getString("recipeId") ?: "",
                onMapDetailClicked = { recipeId, latitude, longitude -> navController.navigate( route = "recipe/$recipeId/maps/$latitude/$longitude") },
                onBackClicked = { navController.goBack() },
            )
        }
        composable(
            route = "recipe/{recipeId}/maps/{latitude}/{longitude}",
            arguments = listOf(
                navArgument("recipeId"){type=NavType.StringType},
                navArgument("latitude"){type=NavType.StringType},
                navArgument("longitude"){type=NavType.StringType}
            )
        ) {
            MapsScreen(
                recipeId = it.arguments?.getString("recipeId") ?: "",
                latitude = it.arguments?.getString("latitude") ?: "",
                longitude = it.arguments?.getString("longitude") ?: "",
                onBackClicked = { navController.goBack() },
            )
        }
    }
}

private fun NavController.goBack() {
    popBackStack()
}