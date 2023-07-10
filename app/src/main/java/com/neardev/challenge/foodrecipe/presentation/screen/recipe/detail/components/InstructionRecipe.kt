package com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.foundation.VitaminTheme

@Composable
fun InstructionRecipe(
    modifier: Modifier = Modifier,
    description: String,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = "Instructions",
            color = VitaminTheme.colors.vtmnContentSecondary,
            style = VitaminTheme.typography.h6,
            //textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = description,
            color = VitaminTheme.colors.vtmnContentSecondary,
            style = VitaminTheme.typography.text3,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}