package com.neardev.challenge.foodrecipe.presentation.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.VitaminIcons
import com.decathlon.vitamin.compose.appbars.bottomnavigations.SelectedActionItem
import com.decathlon.vitamin.compose.appbars.bottomnavigations.VitaminBottomNavigations
import com.decathlon.vitamin.compose.appbars.topbars.ActionItem
import com.decathlon.vitamin.compose.appbars.topbars.SearchActionItem
import com.decathlon.vitamin.compose.appbars.topbars.VitaminTopBars
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.vitaminicons.Line
import com.decathlon.vitamin.compose.vitaminicons.line.Github
import com.decathlon.vitamin.compose.vitaminicons.line.Search
import com.google.android.material.slider.BaseOnChangeListener
import com.neardev.challenge.foodrecipe.R
import com.neardev.challenge.foodrecipe.presentation.navigation.NavItemHome
import com.neardev.challenge.foodrecipe.utilities.openLink
import com.neardev.challenge.foodrecipe.utilities.preview.PreviewParameterProviderDark

@Composable
fun HomeTopBar(
    context: Context = LocalContext.current,
){
    VitaminTopBars.Primary(
        title = "App Food Recipes",
        navigationIcon = {
            Drawer(enabled = false, onClick = {}, contentDescription = "Home")
        },
        actions = arrayListOf(
            ActionItem(
                icon = rememberVectorPainter(image = VitaminIcons.Line.Github),
                contentDescription = "Link Github",
                content = { Text("Github") },
                onClick = {
                    openLink(
                        context,
                        "https://github.com/NearApps/FoodRecipesChallenge"
                    )
                }
            ),
        ),
    )
}

@Composable
fun AppTopBar(
    title: String,
    onBackClick : () -> Unit = {}
){
    VitaminTopBars.Primary(
        title = title,
        navigationIcon = {
            Context(onClick = { onBackClick() }, contentDescription = "Back")
        },
    )
}

@Composable
fun HomeBarSearch(
    onChangeListener: (String) -> Unit = {},
    onClickClose: () -> Unit = {}
) {
    val searching = remember { mutableStateOf("") }
    VitaminTopBars.Search(
        value = searching.value,
        placeholder = "Type to search",
        onValueChange = {
            searching.value = it
            onChangeListener(searching.value)
        },
        navigationIcon = {
            if (searching.value == "") {
                Search(contentDescription = "Apply search")
            } else {
                Context(
                    onClick = {
                        searching.value = ""
                        onClickClose()
                    },
                    contentDescription = "Back"
                )
            }
        },
        actions = arrayListOf(
            SearchActionItem.Close(
                contentDescription = "Close search bar",
                onClick = {
                    searching.value = ""
                    onClickClose()
                }
            )
        ),
    )
}

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
            /*SelectedActionItem(
                selected = selectedBottomNav.value == NavItemHome.INGREDIENTS.route,
                icon = painterResource(R.drawable.ic_ingredients),
                contentDescription = "Ingredients Icon",
                text = "Ingredients",
                onClick = {
                    selectedBottomNav.value = NavItemHome.INGREDIENTS.route
                    onBottomNavSelected(NavItemHome.INGREDIENTS.route);
                    return@SelectedActionItem true
                }
            )*/
        )
    )
}

@Preview
@Composable
private fun DetailTopBarPreview(
    @PreviewParameter(PreviewParameterProviderDark::class) isDark: Boolean
) {
    VitaminTheme( darkTheme = isDark) {
        Column {
            HomeTopBar()
            Spacer(modifier = Modifier.height(10.dp))
            AppTopBar( title = "Title" )
            Spacer(modifier = Modifier.height(10.dp))
            HomeBarSearch()
            Spacer(modifier = Modifier.height(10.dp))
            AppBottonBar()
        }
    }
}