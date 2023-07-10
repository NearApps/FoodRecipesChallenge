package com.neardev.challenge.foodrecipe.presentation.screen.nav_home.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.decathlon.vitamin.compose.appbars.topbars.SearchActionItem
import com.decathlon.vitamin.compose.appbars.topbars.VitaminTopBars
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.neardev.challenge.foodrecipe.utilities.PreviewParameterProviderDark

@Composable
fun HomeBarSearch(
    searching: MutableState<String>,
    onClickClose: () -> Unit = {}
) {
    VitaminTopBars.Search(
        value = searching.value,
        placeholder = "Type to search",
        onValueChange = { searching.value = it },
        navigationIcon = {
            if (searching.value == "") {
                Search(contentDescription = "Apply search")
            } else {
                Context(
                    onClick = {
                        onClickClose()
                        searching.value = ""
                    },
                    contentDescription = "Back"
                )
            }
        },
        actions = arrayListOf(
            SearchActionItem.Close(
                contentDescription = "Close search bar",
                onClick = {
                    onClickClose()
                    searching.value = ""
                }
            )
        ),
    )
}

@Preview
@Composable
fun HomeBarSearchPreview(
    @PreviewParameter(PreviewParameterProviderDark::class) isDark: Boolean
) {
    VitaminTheme( darkTheme = isDark) {
        HomeBarSearch(
            searching = remember { mutableStateOf("") }
        )
    }
}