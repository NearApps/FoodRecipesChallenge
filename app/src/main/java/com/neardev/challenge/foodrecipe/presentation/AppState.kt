package com.neardev.challenge.foodrecipe.presentation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.runBlocking

@Composable
fun rememberAppState(): AppState {
    val context = LocalContext.current
    return remember {
        AppState(context)
    }
}

class AppState(private val context: Context) {
    val startDestination: String = runBlocking {"home"}

    fun setStartDestination(feature: String) {
        runBlocking { // TODO: This is blocking the UI. Do it better
            "home"//startDestination = feature.route
        }
    }
}
