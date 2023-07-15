package com.neardev.challenge.foodrecipe.di.data

import com.neardev.challenge.foodrecipe.data.remote.datasource.api.ApiRecipeDatasource
import com.neardev.challenge.foodrecipe.data.remote.datasource.RemoteRecipeDatasource
import com.neardev.challenge.foodrecipe.data.remote.service.FoodService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatasourceModule {

    @Provides
    @Singleton
    fun provideRecipeDatasource(
        foodService: FoodService,
    ): ApiRecipeDatasource = RemoteRecipeDatasource(foodService)

}