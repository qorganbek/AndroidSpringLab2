package com.example.historicalfigures.model.network

import com.example.historicalfigures.model.service.HistoricalFiguresService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val apiUrl: String = "https://api.api-ninjas.com/v1/"
    private val api_key: String = "Y3cidImKQ7KxYtWYYTvNcg==qNgyZm4Sa8izzUod"

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(Interceptor { chain ->  
            val originalRequest = chain.request()
            val newRequest = originalRequest.newBuilder()
                .header("X-Api-Key", api_key)
                .build()
            chain.proceed(newRequest)
        })
    }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(apiUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val instance = retrofit.create(HistoricalFiguresService::class.java)
}