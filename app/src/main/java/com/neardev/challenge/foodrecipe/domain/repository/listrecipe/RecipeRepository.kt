package com.neardev.challenge.foodrecipe.domain.repository.listrecipe

import arrow.core.Either
import com.neardev.challenge.foodrecipe.domain.model.Category
import com.neardev.challenge.foodrecipe.domain.model.Ingredient
import com.neardev.challenge.foodrecipe.domain.model.Recipe
import com.neardev.challenge.foodrecipe.domain.model.RecipeDetail

interface RecipeRepository {

    // get list categories and ingredients
    suspend fun getAllCategories(): Either<Throwable, List<Category>>
    suspend fun getAllIngredients(): Either<Throwable, List<Ingredient>>

    // get list recipes by filter
    suspend fun getFilterByName(search: String): Either<Throwable, List<Recipe>>
    suspend fun getFilterByCategory(category: String): Either<Throwable, List<Recipe>>
    suspend fun getFilterByIngredient(ingredient: String): Either<Throwable, List<Recipe>>

    //get recipe detail by id
    suspend fun getRecipeById(idRecipe: String): Either<Throwable, RecipeDetail>

}