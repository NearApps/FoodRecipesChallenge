package com.neardev.challenge.foodrecipe.data.remote.client

import com.neardev.challenge.foodrecipe.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.internal.platform.android.AndroidLogHandler.setLevel
import okhttp3.logging.HttpLoggingInterceptor

object APIClient {

    fun createHttpClient(): OkHttpClient {
        val requestInterceptor = Interceptor { chain ->
            val request = chain
                .request()
                .newBuilder()

            //request.addHeader(AUTHORIZATION, ApiToken)
            request.addHeader("authority", "www.themealdb.com")
            request.addHeader("accept-language", "es-ES,es;q=0.9")
            request.addHeader("cache-control", "max-age=0")
            request.addHeader("sec-ch-ua-mobile", "?0")
            request.addHeader("sec-fetch-dest", "document")
            request.addHeader("sec-fetch-mode", "navigate")
            request.addHeader("sec-fetch-site", "none")
            request.addHeader("sec-fetch-user", "?1")
            request.addHeader("upgrade-insecure-requests", "1")
            request.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")

            return@Interceptor chain.proceed(request.build())
        }

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = when {
            BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
            else -> HttpLoggingInterceptor.Level.NONE
        }

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(httpLoggingInterceptor)
        return httpClient.build()
    }
}
