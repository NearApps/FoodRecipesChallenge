package com.neardev.challenge.foodrecipe.presentation

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.neardev.challenge.foodrecipe.presentation.components.AppBottonBar
import com.neardev.challenge.foodrecipe.presentation.components.AppTopBar
import com.neardev.challenge.foodrecipe.presentation.components.HomeTopBar
import com.neardev.challenge.foodrecipe.presentation.navigation.AppNavigation
import com.neardev.challenge.foodrecipe.presentation.navigation.isHome
import com.neardev.challenge.foodrecipe.presentation.navigation.navigatePoppingUpToStartDestination
import com.neardev.challenge.foodrecipe.presentation.screen.ProvideMultiViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp(
                backDispatcher = onBackPressedDispatcher
            )
        }
    }
}

@Composable
fun MainApp(
    backDispatcher: OnBackPressedDispatcher
){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""
    val context: Context = LocalContext.current

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

        ProvideWindowInsets {
            ProvideMultiViewModel {
                Scaffold(
                    topBar = {
                        if (currentRoute.isHome()) {
                            HomeTopBar(context = context)
                        } else {
                            AppTopBar(
                                title = "Detail Restaurant",
                                onBackClick = { navController.popBackStack() }
                            )
                        }
                    },
                    bottomBar = {
                        if (currentRoute.isHome()) {
                            AppBottonBar(
                                onBottomNavSelected = { route ->
                                    navController.navigatePoppingUpToStartDestination(
                                        route
                                    )
                                }
                            )
                        }
                    },
                ) { padding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
                        AppNavigation(navController)
                    }
                }
            }
        }
    }
}