package com.neardev.challenge.foodrecipe.presentation.screen.home.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.decathlon.vitamin.compose.VitaminIcons
import com.decathlon.vitamin.compose.appbars.topbars.ActionItem
import com.decathlon.vitamin.compose.appbars.topbars.VitaminTopBars
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.vitaminicons.Line
import com.decathlon.vitamin.compose.vitaminicons.line.Github
import com.neardev.challenge.foodrecipe.utilities.PreviewParameterProviderDark

@Composable
fun HomeTopBar(
    context: Context = LocalContext.current,
){
    VitaminTopBars.Primary(
        title = "App Food Recipes",
        navigationIcon = {
            Drawer(enabled = false, onClick = {}, contentDescription = "Home")
        },
        actions = arrayListOf(
            ActionItem(
                icon = rememberVectorPainter(image = VitaminIcons.Line.Github),
                contentDescription = "Link Github",
                content = { Text("Github") },
                onClick = {
                    context.startActivity(
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/NearApps/FoodRecipesChallenge"))
                    )
                }
            ),
        ),
    )
}

@Preview
@Composable
fun HomeTopBarSearchPreview(
    @PreviewParameter(PreviewParameterProviderDark::class) isDark: Boolean
) {
    VitaminTheme( darkTheme = isDark) { HomeTopBar() }
}