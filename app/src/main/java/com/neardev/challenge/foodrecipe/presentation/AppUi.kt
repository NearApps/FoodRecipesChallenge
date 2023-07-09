package com.neardev.challenge.foodrecipe.presentation

import android.annotation.SuppressLint
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.neardev.challenge.foodrecipe.presentation.navigation.AppNavigation
import com.neardev.challenge.foodrecipe.presentation.screen.ProvideMultiViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppUi(
    backDispatcher: OnBackPressedDispatcher,
    appState: AppState = rememberAppState(),
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    VitaminTheme {
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = MaterialTheme.colors.isLight
        val navigationColor = MaterialTheme.colors.background
        val statusColor = VitaminTheme.colors.vtmnBackgroundPrimary
        SideEffect {
            systemUiController.setStatusBarColor(
                color = statusColor,
                darkIcons = useDarkIcons
            )
            systemUiController.setNavigationBarColor(
                color = navigationColor,
                darkIcons = useDarkIcons
            )
        }

        ProvideMultiViewModel {
            AppNavigation(navController, appState)
            /*Scaffold(
                modifier = Modifier,
                /*topBar = {
                    TopAppBar(
                        title = { Text(text = "Top Bar") },
                    )
                },*/
                bottomBar = {},
                content = {
                    AppNavigation(navController, appState)
                }
            )*/
        }
    }
}