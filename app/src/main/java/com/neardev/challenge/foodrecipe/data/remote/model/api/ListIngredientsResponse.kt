package com.neardev.challenge.foodrecipe.data.remote.model.api

import com.neardev.challenge.foodrecipe.data.remote.model.api.item.ItemIngredientResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListIngredientsResponse(
    @Json(name = "meals")       val ingredients:     List<ItemIngredientResponse>
)