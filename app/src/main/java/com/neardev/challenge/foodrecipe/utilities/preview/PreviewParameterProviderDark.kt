package com.neardev.challenge.foodrecipe.utilities.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class PreviewParameterProviderDark: PreviewParameterProvider<Boolean> {
    override val values = sequenceOf(false,true)
}