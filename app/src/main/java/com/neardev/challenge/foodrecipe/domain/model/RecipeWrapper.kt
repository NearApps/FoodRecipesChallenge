package com.neardev.challenge.foodrecipe.domain.model

data class RecipeWrapper(
    val total: Int,
    val recipes: List<Recipe>,
){
    fun isEmpty() = recipes.isEmpty()
}