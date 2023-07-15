package com.neardev.challenge.foodrecipe.di

import com.neardev.challenge.foodrecipe.data.remote.client.APIClient
import com.neardev.challenge.foodrecipe.data.remote.service.FoodService
import com.neardev.challenge.foodrecipe.di.data.RemoteDataModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RemoteDataModule::class]
)
object TestRemoteDataModule {

    @Provides
    fun provideHttpClient(): OkHttpClient = APIClient.createHttpClient()

    @Provides
    @Singleton
    @BaseUrl
    fun provideUrl(): String = TEST_BASE_URL

    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        @BaseUrl baseUrl: String,
    ): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideFoodService(
        retrofit: Retrofit,
    ): FoodService = retrofit.create(FoodService::class.java)
}

private const val TEST_BASE_URL = "http://localhost:8080/"