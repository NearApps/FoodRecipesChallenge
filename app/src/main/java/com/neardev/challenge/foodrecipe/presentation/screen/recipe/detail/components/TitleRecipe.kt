package com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.ratings.VitaminRatingSizes
import com.decathlon.vitamin.compose.ratings.VitaminRatings
import com.neardev.challenge.foodrecipe.R
import kotlin.random.Random

@Composable
fun TittleRecipe(
    modifier: Modifier = Modifier,
    title: String = "Recipe Name",
    onMapDetailClicked: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(.8f),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = title,
                color = VitaminTheme.colors.vtmnContentSecondary,
                style = VitaminTheme.typography.h6,
                //textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(),
            )
            VitaminRatings.ReadOnly(
                number = (Random.nextFloat() * (5 - 1) + 1),
                nbComments = (0..80).random(),
                showNote = true,
                sizes = VitaminRatingSizes.small(),
                //colors = colors
            )
        }
        Column(
            modifier = Modifier
                .weight(.2f)
                .clickable { onMapDetailClicked() },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_map),
                contentDescription = "Maps Icon",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(10.dp),
            )
            Text(
                text = "View on map",
                color = VitaminTheme.colors.vtmnContentSecondary,
                style = VitaminTheme.typography.caption,
                //textAlign = TextAlign.Center,
                modifier = Modifier
            )
        }
    }
}