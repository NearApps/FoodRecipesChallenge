package com.neardev.challenge.foodrecipe.presentation.screen.nav_home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.foundation.vtmnTypography
import com.neardev.challenge.foodrecipe.presentation.screen.ViewModelProvider
import com.neardev.challenge.foodrecipe.presentation.screen.nav_home.components.HomeBarSearch


@Composable
fun NavHomeScreen(
    onDetailClicked: (String) -> Unit
) {

    val context = LocalContext.current
    val scrollState = rememberLazyListState()
    val homeViewModel = ViewModelProvider.homeViewModel
    val viewState = homeViewModel.viewState
    val searching = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        //homeViewModel.onViewScreen()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        HomeBarSearch( searching = searching )

        Text(
            text = if (searching.value.isEmpty()) { "Categories" } else { "Searching for \"${searching.value}\"" },
            color = VitaminTheme.colors.vtmnContentSecondary,
            style = vtmnTypography.h6,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize()
        ) {
            when (viewState) {
                is NavHomeViewModel.ViewState.Loading -> {
                    item {
                        Text(text = "Loading")
                        Button(onClick = { onDetailClicked("1") }) {
                            Text(text = "Open Detail")
                        }
                    }
                }
                is NavHomeViewModel.ViewState.Error -> {
                    item {
                        Text(text = "Error")
                    }
                }
                /*is HomeViewModel.ViewState.Content -> {
                    item {

                    }
                }*/
            }
        }
    }
}