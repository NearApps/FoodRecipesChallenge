package com.neardev.challenge.foodrecipe.presentation.components.app_bars

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.decathlon.vitamin.compose.appbars.topbars.VitaminTopBars
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.neardev.challenge.foodrecipe.utilities.PreviewParameterProviderDark

@Composable
fun AppTopBar(
    title: String,
    onBackClick : () -> Unit = {}
){
    VitaminTopBars.Primary(
        title = title,
        navigationIcon = {
            Context(onClick = { onBackClick() }, contentDescription = "Back")
        },
    )
}

@Preview
@Composable
fun DetailTopBarPreview(
    @PreviewParameter(PreviewParameterProviderDark::class) isDark: Boolean
) {
    VitaminTheme( darkTheme = isDark) {
        AppTopBar(
            title = "Title",
        )
    }
}