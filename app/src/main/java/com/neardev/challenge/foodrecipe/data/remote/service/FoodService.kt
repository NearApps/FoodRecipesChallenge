package com.neardev.challenge.foodrecipe.data.remote.service

import com.neardev.challenge.foodrecipe.data.remote.model.api.ListCategoriesResponse
import com.neardev.challenge.foodrecipe.data.remote.model.api.ListIngredientsResponse
import com.neardev.challenge.foodrecipe.data.remote.model.api.ListRecipesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodService {

   // get list categories and ingredients
    @GET("categories.php")
    suspend fun getAllCategories(): ListCategoriesResponse
    @GET("list.php?i=list")
    suspend fun getAllIngredients(): ListIngredientsResponse

    // get list recipes by filter
    @GET("search.php")
    suspend fun getFilterByName(@Query("s") search: String): ListRecipesResponse
    @GET("filter.php")
    suspend fun getFilterByCategory(@Query("c") category: String): ListRecipesResponse
    @GET("filter.php")
    suspend fun getFilterByIngredient(@Query("i") ingredient: String): ListRecipesResponse

    //get recipe detail by id
    @GET("lookup.php")
    suspend fun getRecipeById(@Query("i") idReipe: String): ListRecipesResponse

}