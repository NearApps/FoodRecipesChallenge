package com.neardev.challenge.foodrecipe.data.remote.model.api

import com.neardev.challenge.foodrecipe.data.remote.model.api.item.ItemRecipeResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListRecipesResponse(
    @Json(name = "meals")      val recipes:      List<ItemRecipeResponse>?
)