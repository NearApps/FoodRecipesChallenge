package com.neardev.challenge.foodrecipe.data.remote.mapper

import com.neardev.challenge.foodrecipe.data.remote.model.api.ListRecipesResponse
import com.neardev.challenge.foodrecipe.data.remote.model.api.item.ItemRecipeResponse
import com.neardev.challenge.foodrecipe.domain.model.Recipe
import com.neardev.challenge.foodrecipe.domain.model.RecipeDetail
import kotlin.random.Random

fun ListRecipesResponse.toDomain(): List<Recipe> = recipes?.map { it.toDomain() } ?: emptyList()
fun ListRecipesResponse.toDetailDomain(): List<RecipeDetail> = recipes?.map { it.toDetailDomain() } ?: emptyList()

fun ItemRecipeResponse.toDomain(): Recipe {
    return Recipe(
        id = id,
        name = name,
        tags = tags ?: "",
        img_url = img_url,
    )
}
fun ItemRecipeResponse.toDetailDomain(): RecipeDetail {
    return RecipeDetail(
        id = id,
        name = name,
        tags = tags ?: "",
        rate = (Random.nextFloat() * (5 - 1) + 1),
        comments = (0..80).random(),
        img_url = img_url,
        youtube = youtube_url ?: "",
        latitude = listOf("-14.0760343", "-14.071171", "-14.0704945", "-14.0694322", "-14.0698886", "-14.0713422")[(0..5).random()],
        longitude = listOf("-75.7304684", "-75.7273376", "-75.72494,18.94", "-75.7270827", "-75.7295392", "-75.7287493")[(0..5).random()],
        instruccions = instruccions ?: "No Instructions",
        ingredients = generateListNotNullsAndEmpty(
            ingredient1,
            ingredient2,
            ingredient3,
            ingredient4,
            ingredient5,
            ingredient6,
            ingredient7,
            ingredient8,
            ingredient8,
            ingredient10,
            ingredient11,
            ingredient12,
            ingredient13,
            ingredient14,
            ingredient15,
            ingredient16,
            ingredient17,
            ingredient18,
            ingredient19,
            ingredient20,
        ),
        cants = generateListNotNullsAndEmpty(
            cant1,
            cant2,
            cant3,
            cant4,
            cant5,
            cant6,
            cant7,
            cant8,
            cant8,
            cant10,
            cant11,
            cant12,
            cant13,
            cant14,
            cant15,
            cant16,
            cant17,
            cant18,
            cant19,
            cant20,
        ),
    )
}

fun generateListNotNullsAndEmpty(vararg elements: String?): List<String> {
    return elements.filterNotNull().filter { it.isNotEmpty() && it.isNotBlank() }
}