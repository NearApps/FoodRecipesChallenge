package com.neardev.challenge.foodrecipe.data.remote.mapper

import com.neardev.challenge.foodrecipe.data.remote.model.api.ListCategoriesResponse
import com.neardev.challenge.foodrecipe.data.remote.model.api.item.ItemCategoryResponse
import com.neardev.challenge.foodrecipe.domain.model.Category

fun ListCategoriesResponse.toDomain(): List<Category> = categories?.map { it.toDomain() } ?: emptyList()

fun ItemCategoryResponse.toDomain(): Category {
    return Category(
        id = id,
        name = name,
        description = description,
        img_url = image,
    )
}