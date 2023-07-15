package com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.VitaminIcons
import com.decathlon.vitamin.compose.buttons.VitaminIconButtons
import com.decathlon.vitamin.compose.vitaminicons.Fill
import com.decathlon.vitamin.compose.vitaminicons.Line
import com.decathlon.vitamin.compose.vitaminicons.fill.Heart
import com.decathlon.vitamin.compose.vitaminicons.line.Heart
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.glide.GlideImageState

@Composable
fun HeaderRecipe(
    modifier: Modifier = Modifier,
    imageUrl: String,
    isFavorite: Boolean = false,
    onFavoriteClick: (active: Boolean) -> Unit = {},
) {
    val isFavoriteRecipe = remember { mutableStateOf(isFavorite) }

    Box(
        modifier = modifier,
    ){
        /*Image(
            painter = painterResource(id = R.drawable.wvpsxx1468256321),
            contentDescription = "Recipe Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize(),
        )*/
        GlideImage(
            imageModel = { imageUrl },
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            ),
            loading = {
                Box(modifier = Modifier.matchParentSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .then(Modifier.size(32.dp))
                            .align(Alignment.Center)
                    )
                }
            },
            failure = {
                Text(text = "image request failed.")
            }
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