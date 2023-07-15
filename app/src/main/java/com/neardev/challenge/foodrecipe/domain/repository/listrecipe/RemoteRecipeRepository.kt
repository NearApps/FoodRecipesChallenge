package com.neardev.challenge.foodrecipe.domain.repository.listrecipe

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.neardev.challenge.foodrecipe.data.remote.datasource.api.ApiRecipeDatasource
import com.neardev.challenge.foodrecipe.data.remote.mapper.toDetailDomain
import com.neardev.challenge.foodrecipe.data.remote.mapper.toDomain
import com.neardev.challenge.foodrecipe.domain.model.Category
import com.neardev.challenge.foodrecipe.domain.model.Ingredient
import com.neardev.challenge.foodrecipe.domain.model.Recipe
import com.neardev.challenge.foodrecipe.domain.model.RecipeDetail

class RemoteRecipeRepository(
    private val recipeDatasource: ApiRecipeDatasource,
): RecipeRepository {
    override suspend fun getAllCategories(): Either<Throwable, List<Category>> {
        return recipeDatasource.getAllCategories().map { it.toDomain() }
    }

    override suspend fun getAllIngredients(): Either<Throwable, List<Ingredient>> {
        return recipeDatasource.getAllIngredients().map { it.toDomain() }
    }

    override suspend fun getFilterByName(search: String): Either<Throwable, List<Recipe>> {
        return recipeDatasource.getFilterByName(search).map { it.toDomain() }
    }

    override suspend fun getFilterByCategory(category: String): Either<Throwable, List<Recipe>> {
        return recipeDatasource.getFilterByCategory(category).map { it.toDomain() }
    }

    override suspend fun getFilterByIngredient(ingredient: String): Either<Throwable, List<Recipe>> {
        return recipeDatasource.getFilterByIngredient(ingredient).map { it.toDomain() }
    }

    override suspend fun getRecipeById(idRecipe: String): Either<Throwable, RecipeDetail> {
        return recipeDatasource.getRecipeById(idRecipe)
            .fold(
                { fail -> fail.left() },
                { listRecipes ->
                    if (listRecipes.right().isEmpty())
                        Throwable("Detail Recipe not Found").left()
                    else
                        listRecipes.toDetailDomain().first().right()
                }
            )
    }
}