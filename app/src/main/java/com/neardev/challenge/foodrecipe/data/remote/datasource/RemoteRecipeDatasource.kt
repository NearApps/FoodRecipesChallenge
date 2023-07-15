package com.neardev.challenge.foodrecipe.data.remote.datasource

import arrow.core.Either
import com.neardev.challenge.foodrecipe.data.remote.datasource.api.ApiRecipeDatasource
import com.neardev.challenge.foodrecipe.data.remote.mapper.toDomain
import com.neardev.challenge.foodrecipe.data.remote.model.api.ListCategoriesResponse
import com.neardev.challenge.foodrecipe.data.remote.model.api.ListIngredientsResponse
import com.neardev.challenge.foodrecipe.data.remote.model.api.ListRecipesResponse
import com.neardev.challenge.foodrecipe.data.remote.service.FoodService
import com.neardev.challenge.foodrecipe.domain.model.Recipe
import javax.inject.Inject

class RemoteRecipeDatasource @Inject constructor(
    private val foodService: FoodService
): ApiRecipeDatasource {
    override suspend fun getAllCategories(): Either<Throwable, ListCategoriesResponse> {
        return Either.catch { foodService.getAllCategories() }
    }

    override suspend fun getAllIngredients(): Either<Throwable, ListIngredientsResponse> {
        return Either.catch { foodService.getAllIngredients() }
    }

    override suspend fun getFilterByName(search: String): Either<Throwable, ListRecipesResponse> {
        return Either.catch { foodService.getFilterByName(search) }
    }

    override suspend fun getFilterByCategory(category: String): Either<Throwable, ListRecipesResponse> {
        return Either.catch { foodService.getFilterByCategory(category) }
    }

    override suspend fun getFilterByIngredient(ingredient: String): Either<Throwable, ListRecipesResponse> {
        return Either.catch { foodService.getFilterByIngredient(ingredient) }
    }

    override suspend fun getRecipeById(idRecipe: String): Either<Throwable, ListRecipesResponse> {
        return Either.catch { foodService.getRecipeById(idRecipe) }
    }

}