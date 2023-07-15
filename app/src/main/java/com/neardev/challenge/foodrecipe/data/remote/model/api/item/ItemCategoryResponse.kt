package com.neardev.challenge.foodrecipe.data.remote.model.api.item

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemCategoryResponse(
    @Json(name = "idCategory")               val id:             String,
    @Json(name = "strCategory")              val name:           String,
    @Json(name = "strCategoryDescription")   val description:    String,
    @Json(name = "strCategoryThumb")         val image:          String
)