package com.neardev.challenge.foodrecipe.presentation.screen.nav_ingredient

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NavIngredientScreen (
    onListRecipesClicked: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(text = "Ingredient Screen")
        Button(
            onClick = { onListRecipesClicked("1") }
        ) {
            Text(text = "Go to Recipes")
        }
    }
}