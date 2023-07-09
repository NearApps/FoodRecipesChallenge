package com.neardev.challenge.foodrecipe.presentation.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavCommand(
    internal val navRoute: String,
    private val navArgs: List<NavArg> = emptyList(),
) {
    class Home: NavCommand("home") {
        fun createRoute() = "home"
    }

    class ContentDetail(navArgs: List<NavArg>, ) : NavCommand("detail", navArgs) {
        fun createRoute(recipeId: String) = "$navRoute/$recipeId"
    }

    class ContentMapRecipe(navArgs: List<NavArg>, ) : NavCommand("maps", navArgs) {
        fun createRoute(recipeIdMap: String) = "$navRoute/$recipeIdMap"
        fun createRoute(recipeIdMap: String, latitude: String, longitude: String ) = "$navRoute/$recipeIdMap/$latitude/$longitude"
    }

    val route = run {
        val argValues = navArgs.map { "{${it.key}}" }
        listOf(navRoute)
            .plus(argValues)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }
}

enum class NavArg(
    val key: String,
    val navType: NavType<*>,
) {
    RecipeId("recipeId", NavType.StringType),
    Latitude("latitude", NavType.StringType),
    Longitude("longitude", NavType.StringType),
}