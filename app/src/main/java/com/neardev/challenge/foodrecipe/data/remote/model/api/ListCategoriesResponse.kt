package com.neardev.challenge.foodrecipe.data.remote.model.api

import com.neardev.challenge.foodrecipe.data.remote.model.api.item.ItemCategoryResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListCategoriesResponse(
    @Json(name = "categories")  val categories:     List<ItemCategoryResponse>
)