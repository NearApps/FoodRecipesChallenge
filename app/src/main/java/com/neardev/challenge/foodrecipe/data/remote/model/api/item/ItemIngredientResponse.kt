package com.neardev.challenge.foodrecipe.data.remote.model.api.item

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemIngredientResponse (
    @Json(name = "idIngredient")        val id:                 String,
    @Json(name = "strIngredient")       val name:               String,
    @Json(name = "strDescription")      val description:        String?,
    @Json(name = "strType")             val type:               String?,
)