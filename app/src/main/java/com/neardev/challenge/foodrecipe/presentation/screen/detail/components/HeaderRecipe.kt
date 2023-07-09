package com.neardev.challenge.foodrecipe.presentation.screen.detail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.VitaminIcons
import com.decathlon.vitamin.compose.buttons.VitaminIconButtons
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.ratings.VitaminRatingColors
import com.decathlon.vitamin.compose.ratings.VitaminRatingSizes
import com.decathlon.vitamin.compose.ratings.VitaminRatings
import com.decathlon.vitamin.compose.vitaminicons.Fill
import com.decathlon.vitamin.compose.vitaminicons.Line
import com.decathlon.vitamin.compose.vitaminicons.fill.Add
import com.decathlon.vitamin.compose.vitaminicons.fill.ArrowLeft
import com.decathlon.vitamin.compose.vitaminicons.fill.ArrowRight
import com.decathlon.vitamin.compose.vitaminicons.fill.Heart
import com.decathlon.vitamin.compose.vitaminicons.fill.Safari
import com.decathlon.vitamin.compose.vitaminicons.fill.Share
import com.decathlon.vitamin.compose.vitaminicons.fill.Star
import com.decathlon.vitamin.compose.vitaminicons.line.Heart
import com.neardev.challenge.foodrecipe.R

@Composable
fun HeaderRecipe(
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false,
    onFavoriteClick: (active: Boolean) -> Unit = {},
) {
    val isFavoriteRecipe = remember { mutableStateOf(isFavorite) }

    Box(
        modifier = modifier,
    ){
        Image(
            painter = painterResource(id = R.drawable.wvpsxx1468256321),
            contentDescription = "Recipe Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize(),
        )
        Row(
            modifier = Modifier
                //.background( color = VitaminTheme.colors.vtmnBorderPrimary)
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ){
            VitaminIconButtons.PrimaryReversed(
                icon = rememberVectorPainter(if (isFavoriteRecipe.value) VitaminIcons.Fill.Heart else VitaminIcons.Line.Heart),
                contentDescription = "Add",
                onClick = {
                    isFavoriteRecipe.value = !isFavoriteRecipe.value
                    onFavoriteClick(isFavoriteRecipe.value)
                },
            )
        }
    }
}