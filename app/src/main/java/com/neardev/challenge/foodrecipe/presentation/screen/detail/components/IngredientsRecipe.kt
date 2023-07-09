package com.neardev.challenge.foodrecipe.presentation.screen.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.foundation.VitaminTheme

@Composable
fun IngredientsRecipe(
    modifier: Modifier = Modifier,
    list_ingredient: List<String> = listOf(),
    list_measure: List<String> = listOf(),
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = "Ingredients",
            color = VitaminTheme.colors.vtmnContentSecondary,
            style = VitaminTheme.typography.h6,
            //textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(10.dp))

        list_ingredient.forEachIndexed { id, ingredient ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                //horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = ingredient,
                    color = VitaminTheme.colors.vtmnContentSecondary,
                    style = VitaminTheme.typography.text3Bold,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .weight(.6f)
                )
                Text(
                    text = if(list_measure.size > id) ": ${list_measure[id]}" else ": ",
                    color = VitaminTheme.colors.vtmnContentSecondary,
                    style = VitaminTheme.typography.text3,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .weight(.4f)
                )
            }
        }
    }
}