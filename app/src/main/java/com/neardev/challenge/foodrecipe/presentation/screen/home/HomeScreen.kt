package com.neardev.challenge.foodrecipe.presentation.screen.home

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.decathlon.vitamin.compose.VitaminIcons
import com.decathlon.vitamin.compose.appbars.topbars.ActionItem
import com.decathlon.vitamin.compose.appbars.topbars.SearchActionItem
import com.decathlon.vitamin.compose.appbars.topbars.VitaminTopBars
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.foundation.vtmnTypography
import com.decathlon.vitamin.compose.vitaminicons.Line
import com.decathlon.vitamin.compose.vitaminicons.line.Github
import com.neardev.challenge.foodrecipe.presentation.screen.ViewModelProvider
import com.neardev.challenge.foodrecipe.presentation.screen.home.components.HomeBarSearch
import com.neardev.challenge.foodrecipe.presentation.screen.home.components.HomeTopBar
import kotlinx.coroutines.withContext


@Composable
fun HomeScreen(
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

    Scaffold(
        ///contentColor = Color.Blue,
        topBar = { HomeTopBar( context = context ) }
    ){ innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
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
                        is HomeViewModel.ViewState.Loading -> {
                            item {
                                Text(text = "Loading")
                                Button(onClick = { onDetailClicked("1") }) {
                                    Text(text = "Open Detail")
                                }
                            }
                        }
                        is HomeViewModel.ViewState.Error -> {
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
    }



}