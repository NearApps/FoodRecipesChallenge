package com.neardev.challenge.foodrecipe.presentation.screen.recipe.maps

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.Circle
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapsScreen(
    recipeId: String,
    latitude: String,
    longitude: String,
    onBackClicked: () -> Unit,
){
    val markerRecipe = LatLng(latitude.toDouble(), longitude.toDouble())

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        GoogleMap(
            modifier = Modifier
                .fillMaxSize(),
            cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(markerRecipe, 18f)
            },
        ){
            Marker(
                title = "Recipe Location",
                snippet = "This is the location of the recipe",
                state = MarkerState(
                    position = markerRecipe
                ),
            )
        }
    }
}