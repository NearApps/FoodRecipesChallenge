package com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neardev.challenge.foodrecipe.presentation.components.app_bars.AppTopBar
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.components.TittleRecipe
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.components.InstructionRecipe
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.components.HeaderRecipe
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.components.IngredientsRecipe
import com.neardev.challenge.foodrecipe.presentation.screen.recipe.detail.components.SocialReciper

@Composable
fun DetailScreen(
    recipeId: String,
    onMapDetailClicked: ( recipeId: String, latitude: String, longitude: String) -> Unit,
    onBackClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ){
        HeaderRecipe(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            onFavoriteClick = { active ->   },
        )
        Column(
            modifier = Modifier
                .padding(20.dp),
        ) {
            TittleRecipe(
                title = "Recipe title",
                onMapDetailClicked = {
                    onMapDetailClicked("22", "55", "44")
                }
            )
            SocialReciper(
                onGithubClick = {},
                onYoutubeClick = {},
                onShareClick = {},
            )
            IngredientsRecipe(
                modifier = Modifier
                    .fillMaxWidth(),
                list_ingredient = listOf("Salmon", "Pasta", "Tomato", "Onion", "Garlic", "Olive oil", "Salt", "Pepper"),
                list_measure = listOf("1", "2", "3", "4 tablespoon", "5 tablespoon", "6 tablespoon", "7", "8 lb"),
            )
            Spacer(modifier = Modifier.height(10.dp))
            InstructionRecipe(
                modifier = Modifier
                    .fillMaxWidth(),
                description = "Al contrario del pensamiento popular, el texto de Lorem Ipsum no es simplemente texto aleatorio. Tiene sus raices en una pieza cl´sica de la literatura del Latin, que data del año 45 antes de Cristo, haciendo que este adquiera mas de 2000 años de antiguedad. Richard McClintock, un profesor de Latin de la Universidad de Hampden-Sydney en Virginia, encontró una de las palabras más oscuras de la lengua del latín, \"consecteur\", en un pasaje de Lorem Ipsum, y al seguir leyendo distintos textos del latín, descubrió la fuente indudable. Lorem Ipsum viene de las secciones 1.10.32 y 1.10.33 de \"de Finnibus Bonorum et Malorum\" (Los Extremos del Bien y El Mal)" +
                        "\nEl trozo de texto estándar de Lorem Ipsum usado desde el año 1500 es reproducido debajo para aquellos interesados. Las secciones 1.10.32 y 1.10.33 de \"de Finibus Bonorum et Malorum\" por Cicero son también reproducidas en su forma original exacta, acompañadas por versiones en Inglés de la traducción realizada en 1914 por H. Rackham."
            )
            //Spacer(modifier = Modifier.height(10.dp))
        }
    }
}