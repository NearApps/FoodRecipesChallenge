package com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.VitaminIcons
import com.decathlon.vitamin.compose.tags.VitaminTagColors
import com.decathlon.vitamin.compose.tags.VitaminTagSizes
import com.decathlon.vitamin.compose.tags.VitaminTags
import com.decathlon.vitamin.compose.vitaminicons.Fill
import com.decathlon.vitamin.compose.vitaminicons.fill.Github
import com.decathlon.vitamin.compose.vitaminicons.fill.Share
import com.decathlon.vitamin.compose.vitaminicons.fill.Youtube

@Composable
fun SocialReciper(
    modifier: Modifier = Modifier,
    onGithubClick: () -> Unit = {},
    onYoutubeClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 5.dp),
        horizontalArrangement = Arrangement.Center,
    ){
        VitaminTags.Accent(
            label = "Github",
            colors = VitaminTagColors.brand(),
            iconPainter = rememberVectorPainter(VitaminIcons.Fill.Github),
            sizes = VitaminTagSizes.medium(),
            onClick = onGithubClick
        )
        Spacer(modifier = Modifier.width(10.dp))
        VitaminTags.Accent(
            label = "Youtube",
            colors = VitaminTagColors.alert(),
            iconPainter = rememberVectorPainter(VitaminIcons.Fill.Youtube),
            sizes = VitaminTagSizes.medium(),
            onClick = onYoutubeClick
        )
        Spacer(modifier = Modifier.width(10.dp))
        VitaminTags.Accent(
            label = "Compartir",
            colors = VitaminTagColors.decorativeGravel(),
            iconPainter = rememberVectorPainter(VitaminIcons.Fill.Share),
            sizes = VitaminTagSizes.medium(),
            onClick = onShareClick
        )
    }
}