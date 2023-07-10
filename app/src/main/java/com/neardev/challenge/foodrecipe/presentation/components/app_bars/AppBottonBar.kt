package com.neardev.challenge.foodrecipe.presentation.components.app_bars

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import com.decathlon.vitamin.compose.VitaminIcons
import com.decathlon.vitamin.compose.appbars.bottomnavigations.SelectedActionItem
import com.decathlon.vitamin.compose.appbars.bottomnavigations.VitaminBottomNavigations
import com.decathlon.vitamin.compose.vitaminicons.Line
import com.decathlon.vitamin.compose.vitaminicons.line.Search
import com.neardev.challenge.foodrecipe.R
import com.neardev.challenge.foodrecipe.navigation.NavItemHome

@Composable
fun AppBottonBar(
    onBottomNavSelected: (String) -> Unit = {}
) {
    val selectedBottomNav = remember { mutableStateOf( NavItemHome.HOME.route ) }

    VitaminBottomNavigations.Primary(
        actions = arrayListOf(
            SelectedActionItem(
                selected = selectedBottomNav.value == NavItemHome.HOME.route,
                icon = rememberVectorPainter(image = VitaminIcons.Line.Search),
                contentDescription = "Home Icon",
                text = "Search",
                onClick = {
                    selectedBottomNav.value = NavItemHome.HOME.route
                    onBottomNavSelected(NavItemHome.HOME.route);
                    return@SelectedActionItem true
                }
            ),
            SelectedActionItem(
                selected = selectedBottomNav.value == NavItemHome.CATEGORY.route,
                icon = painterResource(R.drawable.ic_category),
                contentDescription = "Category Icon",
                text = "Category",
                onClick = {
                    selectedBottomNav.value = NavItemHome.CATEGORY.route
                    onBottomNavSelected(NavItemHome.CATEGORY.route);
                    return@SelectedActionItem true
                }
            ),
            SelectedActionItem(
                selected = selectedBottomNav.value == NavItemHome.AREA.route,
                icon = painterResource(R.drawable.ic_country),
                contentDescription = "Country Icon",
                text = "Country",
                onClick = {
                    selectedBottomNav.value = NavItemHome.AREA.route
                    onBottomNavSelected(NavItemHome.AREA.route);
                    return@SelectedActionItem true
                }
            ),
            SelectedActionItem(
                selected = selectedBottomNav.value == NavItemHome.INGREDIENTS.route,
                icon = painterResource(R.drawable.ic_ingredients),
                contentDescription = "Ingredients Icon",
                text = "Ingredients",
                onClick = {
                    selectedBottomNav.value = NavItemHome.INGREDIENTS.route
                    onBottomNavSelected(NavItemHome.INGREDIENTS.route);
                    return@SelectedActionItem true
                }
            )
        )
    )
}