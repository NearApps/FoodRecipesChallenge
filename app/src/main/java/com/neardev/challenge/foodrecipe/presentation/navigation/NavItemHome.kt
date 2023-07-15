package com.neardev.challenge.foodrecipe.presentation.navigation

enum class NavItemHome(val route: String) {
    HOME("home"),
    CATEGORY("category"),
    //AREA("area"),
    INGREDIENTS("ingredients")
}

fun String.isHome(): Boolean {
    NavItemHome.values().forEach {
        if (it.route == this) {
            return true
        }
    }
    return false
}