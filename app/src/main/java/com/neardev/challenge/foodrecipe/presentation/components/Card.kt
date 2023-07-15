package com.neardev.challenge.foodrecipe.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.cards.VitaminCards
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.neardev.challenge.foodrecipe.R
import com.neardev.challenge.foodrecipe.utilities.preview.PreviewParameterProviderDark
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CardRecipe(
    modifier: Modifier = Modifier,
    title: String,
    imageUrl: String,
    onClick: () -> Unit,
) {
    VitaminCards.Primary(
        modifier = modifier
            .clickable { onClick() }
            .padding(bottom = 8.dp)
    ) {
        if (imageUrl.isEmpty()){
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.xxyupu1468262513),
                contentScale = ContentScale.Crop,
                contentDescription = "Recipe image"
            )
        }else{
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
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.Black.copy(alpha = 0.4f)
                )
        )
        Box(
            modifier = Modifier
                .height(250.dp)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                Text(
                    text = title,
                    style = VitaminTheme.typography.h6,
                    color = Color.White
                )
                Text(
                    text = "Recipe",
                    style = VitaminTheme.typography.text3,
                    color = Color.White,
                )
            }
        }
    }
}

@Composable
fun CardCategory(
    modifier: Modifier = Modifier,
    title: String,
    imageUrl: String,
    onClick: () -> Unit,
) {
    VitaminCards.Primary(
        modifier = modifier
            .clickable { onClick() }
            .padding(bottom = 8.dp)
    ) {
        if (imageUrl.isEmpty()){
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.xxyupu1468262513),
                contentScale = ContentScale.Crop,
                contentDescription = "Category image"
            )
        }else{
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
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.Black.copy(alpha = 0.4f)
                )
        )
        Box(
            modifier = Modifier
                .height(250.dp)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    style = VitaminTheme.typography.h6,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun CardIngredient(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit,
) {
    VitaminCards.Primary(
        modifier = modifier
            .clickable { onClick() }
            .padding(bottom = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .height(250.dp)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    style = VitaminTheme.typography.text2Bold,
                    color = VitaminTheme.colors.vtmnContentSecondary,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Preview
@Composable
private fun CardPreview(
    @PreviewParameter(PreviewParameterProviderDark::class) isDark: Boolean
) {
    VitaminTheme( darkTheme = isDark) {
        Column {
            CardRecipe(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                title = "Card title",
                imageUrl = "",
                onClick = {}
            )
            Spacer(modifier = Modifier.height(10.dp))
            CardCategory(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                title = "Card title",
                imageUrl = "",
                onClick = {}
            )
            Spacer(modifier = Modifier.height(10.dp))
            CardIngredient(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                title = "Card title",
                onClick = {}
            )
        }
    }
}