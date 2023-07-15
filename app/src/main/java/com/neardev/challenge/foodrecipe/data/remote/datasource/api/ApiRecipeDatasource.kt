package com.neardev.challenge.foodrecipe.data.remote.datasource.api

import arrow.core.Either
import com.neardev.challenge.foodrecipe.data.remote.model.api.ListCategoriesResponse
import com.neardev.challenge.foodrecipe.data.remote.model.api.ListIngredientsResponse
import com.neardev.challenge.foodrecipe.data.remote.model.api.ListRecipesResponse

interface ApiRecipeDatasource {

    // get list categories and ingredients
    suspend fun getAllCategories(): Either<Throwable, ListCategoriesResponse>
    suspend fun getAllIngredients(): Either<Throwable, ListIngredientsResponse>

    // get list recipes by filter
    suspend fun getFilterByName(search: String): Either<Throwable, ListRecipesResponse>
    suspend fun getFilterByCategory(category: String): Either<Throwable, ListRecipesResponse>
    suspend fun getFilterByIngredient(ingredient: String): Either<Throwable, ListRecipesResponse>

    //get recipe detail by id
    suspend fun getRecipeById(idRecipe: String): Either<Throwable, ListRecipesResponse>

}