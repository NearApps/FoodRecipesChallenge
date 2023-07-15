package com.neardev.challenge.foodrecipe.data.remote.mapper

import com.neardev.challenge.foodrecipe.data.remote.model.api.ListIngredientsResponse
import com.neardev.challenge.foodrecipe.data.remote.model.api.item.ItemIngredientResponse
import com.neardev.challenge.foodrecipe.domain.model.Ingredient

fun ListIngredientsResponse.toDomain(): List<Ingredient> = ingredients?.map { it.toDomain() } ?: emptyList()

fun ItemIngredientResponse.toDomain(): Ingredient {
    return Ingredient(
        id = id,
        name = name,
        description = description?:"No description",
        img_url = type?:"Undefined",
    )
}