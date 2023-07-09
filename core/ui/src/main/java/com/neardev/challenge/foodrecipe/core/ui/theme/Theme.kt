package com.neardev.challenge.foodrecipe.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.decathlon.vitamin.compose.foundation.VitaminTheme

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    VitaminTheme(
        darkTheme = darkTheme,
        content = content
    )
}
