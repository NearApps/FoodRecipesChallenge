package com.neardev.challenge.foodrecipe.domain.model

data class RecipeDetail (
    val id: String,
    val name: String,
    val tags: String,
    val rate: Float,
    val comments: Int,
    val img_url: String,
    val youtube: String,
    val latitude: String,
    val longitude: String,
    val instruccions: String,
    val ingredients: List<String>,
    val cants: List<String>,
){
    fun getRecipeId() = id
}