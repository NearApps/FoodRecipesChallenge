package com.neardev.challenge.foodrecipe.data.remote.retrofit

import com.neardev.challenge.foodrecipe.core.common.models.remote.retrofit.CategoriesResponse
import com.neardev.challenge.foodrecipe.core.common.models.remote.retrofit.FilterResponse
import com.neardev.challenge.foodrecipe.core.common.models.remote.retrofit.RecipeResponse
import retrofit2.Response

class FoodRepository {

    suspend fun getCategories(): Response<CategoriesResponse> {
        return RetrofitInstance.api.getCategories()
    }

    suspend fun getFilterByCategory(category:String): Response<FilterResponse> {
        return RetrofitInstance.api.getFilterByCategory(category)
    }

    suspend fun getFilterByArea(area:String): Response<FilterResponse> {
        return RetrofitInstance.api.getFilterByArea(area)
    }

    suspend fun getFilterByIngredient(ingredient:String): Response<FilterResponse> {
        return RetrofitInstance.api.getFilterByIngredient(ingredient)
    }

    suspend fun getIngredientList(): Response<FilterResponse>{
        return RetrofitInstance.api.getIngredientList()
    }

    suspend fun getAreaList(): Response<FilterResponse>{
        return RetrofitInstance.api.getAreaList()
    }

    suspend fun search(searchQuery:String): Response<FilterResponse>{
        return RetrofitInstance.api.search(searchQuery)
    }

    suspend fun searchFirstLetter(searchQuery:String): Response<FilterResponse>{
        return RetrofitInstance.api.searchFirstLetter(searchQuery)
    }

    suspend fun getRecipeById(id:String): Response<RecipeResponse>{
        return RetrofitInstance.api.getRecipeById(id)
    }

    suspend fun getRandomRecipe(): Response<RecipeResponse>{
        return RetrofitInstance.api.getRandomRecipe()
    }
}