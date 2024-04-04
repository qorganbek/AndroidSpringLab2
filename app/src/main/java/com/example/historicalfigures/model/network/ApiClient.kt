package com.example.historicalfigures.model.network

import com.example.historicalfigures.R
import com.example.historicalfigures.model.service.HistoricalFiguresService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
        private val apiUrl: String = R.string.api_url.toString()
        private val api_key: String = R.string.api_key.toString()

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