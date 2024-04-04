package com.example.historicalfigures.model.network

import com.example.historicalfigures.model.service.HistoricalFiguresService
import com.example.historicalfigures.utils.apiKey
import com.example.historicalfigures.utils.my_url
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val apiUrl: String = my_url
    private val api_key: String = apiKey

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