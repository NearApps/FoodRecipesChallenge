package com.neardev.challenge.foodrecipe.presentation

import android.content.Context
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.neardev.challenge.foodrecipe.presentation.components.app_bars.AppBottonBar
import com.neardev.challenge.foodrecipe.presentation.components.app_bars.AppTopBar
import com.neardev.challenge.foodrecipe.navigation.AppNavigation
import com.neardev.challenge.foodrecipe.navigation.navigatePoppingUpToStartDestination
import com.neardev.challenge.foodrecipe.presentation.screen.ProvideMultiViewModel
import com.neardev.challenge.foodrecipe.presentation.screen.nav_home.components.HomeTopBar


@Composable
fun AppUi(
    backDispatcher: OnBackPressedDispatcher,
    appState: AppState = rememberAppState(),
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""
    val context: Context = LocalContext.current

    VitaminTheme {
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = MaterialTheme.colors.isLight
        val navigationColor = MaterialTheme.colors.background
        val statusColor = VitaminTheme.colors.vtmnBackgroundPrimary

        //val selectedBottomNav = remember { mutableStateOf("home") }

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

        Surface(
            modifier = Modifier.fillMaxSize(),
            //color = MaterialTheme.colors.background
        ) {
            ProvideMultiViewModel {
                Scaffold(
                    topBar = {
                         if (true){
                             HomeTopBar( context = context )
                         }else{
                             AppTopBar(
                                 title = "Detail Restaurant",
                                 onBackClick = { }
                             )
                         }
                    },
                    bottomBar = {
                        AppBottonBar(
                            onBottomNavSelected = { route -> navController.navigatePoppingUpToStartDestination(route) }
                        )
                    },
                ) { padding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ){
                        AppNavigation(navController, appState)
                    }
                }
            }
        }
    }
}