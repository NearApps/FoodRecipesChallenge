package com.neardev.challenge.foodrecipe.di.data

import com.neardev.challenge.foodrecipe.data.remote.datasource.api.ApiRecipeDatasource
import com.neardev.challenge.foodrecipe.domain.repository.listrecipe.RecipeRepository
import com.neardev.challenge.foodrecipe.domain.repository.listrecipe.RemoteRecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRecipeRepository(
        apiRecipeDatasource: ApiRecipeDatasource,
    ): RecipeRepository = RemoteRecipeRepository(
        apiRecipeDatasource
    )
}
