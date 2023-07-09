package com.neardev.challenge.foodrecipe.presentation.screen.maps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neardev.challenge.foodrecipe.presentation.components.app_bars.AppTopBar

@Composable
fun MapsScreen(
    recipeId: String,
    latitude: String,
    longitude: String,
    onBackClicked: () -> Unit,
){
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Map on Restaurant",
                onBackClick = onBackClicked
            )
        }
    ){ innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Text(text = "Maps Screen")
            }
        }
    }
}