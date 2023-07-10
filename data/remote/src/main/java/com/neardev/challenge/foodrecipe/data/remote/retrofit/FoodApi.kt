package com.neardev.challenge.foodrecipe.data.remote.retrofit

import com.neardev.challenge.foodrecipe.core.common.models.remote.retrofit.CategoriesResponse
import com.neardev.challenge.foodrecipe.core.common.models.remote.retrofit.FilterResponse
import com.neardev.challenge.foodrecipe.core.common.models.remote.retrofit.RecipeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {
    @GET("api/json/v1/1/categories.php")
    suspend fun getCategories(): Response<CategoriesResponse>
    @GET("api/json/v1/1/list.php?i=list")
    suspend fun getIngredientList(): Response<FilterResponse>
    @GET("api/json/v1/1/list.php?a=list")
    suspend fun getAreaList(): Response<FilterResponse>
    @GET("api/json/v1/1/filter.php")
    suspend fun getFilterByCategory(@Query("c") category: String): Response<FilterResponse>
    @GET("api/json/v1/1/filter.php")
    suspend fun getFilterByIngredient(@Query("i") ingredient: String): Response<FilterResponse>
    @GET("api/json/v1/1/filter.php")
    suspend fun getFilterByArea(@Query("a") area: String): Response<FilterResponse>
    @GET("api/json/v1/1/search.php")
    suspend fun search(@Query("s") searchQuery: String): Response<FilterResponse>
    @GET("api/json/v1/1/search.php")
    suspend fun searchFirstLetter(@Query("f") searchQuery: String): Response<FilterResponse>
    @GET("api/json/v1/1/lookup.php")
    suspend fun getRecipeById(@Query("i") id: String): Response<RecipeResponse>
    @GET("api/json/v1/1/random.php")
    suspend fun getRandomRecipe(): Response<RecipeResponse>
}