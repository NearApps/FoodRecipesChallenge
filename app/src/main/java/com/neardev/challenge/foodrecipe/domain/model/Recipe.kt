package com.neardev.challenge.foodrecipe.domain.model

data class Recipe (
    val id: String,
    val name: String,
    val tags: String,
    val img_url: String,
){
    fun getRecipeId() = id
}