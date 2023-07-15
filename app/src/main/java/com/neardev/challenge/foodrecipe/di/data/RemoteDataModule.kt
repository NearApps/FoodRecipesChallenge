package com.neardev.challenge.foodrecipe.di.data

import com.neardev.challenge.foodrecipe.data.remote.client.APIClient
import com.neardev.challenge.foodrecipe.data.remote.service.FoodService
import com.neardev.challenge.foodrecipe.di.BaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideHttpClient(): OkHttpClient = APIClient.createHttpClient()

    @Provides
    @Singleton
    @BaseUrl
    fun provideUrl(): String = BASE_URL

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        @BaseUrl baseUrl: String,
    ): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideFoodService(
        retrofit: Retrofit,
    ): FoodService = retrofit.create(FoodService::class.java)

}

internal const val ONE_DAY_IN_MILLIS = 24 * 60 * 60 * 1000L
private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"