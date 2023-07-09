package com.neardev.challenge.foodrecipe.data.remote.retrofit

import com.neardev.challenge.foodrecipe.data.remote.utilities.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.level = (HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val api:FoodApi by lazy {
            retrofit.create(FoodApi::class.java)
        }

    }
}