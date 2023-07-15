package com.neardev.challenge.foodrecipe.domain.model

data class Category (
    val id: String,
    val name: String,
    val description: String,
    val img_url: String,
){
    fun getCategoryId() = id
}