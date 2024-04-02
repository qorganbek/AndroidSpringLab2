package com.example.historicalfigures.model.network

import com.example.historicalfigures.model.entity.HistoricalFigures
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val apiUrl: String = "https://api.api-ninjas.com/v1/historicalfigures"
    private val retrofit = Retrofit.Builder()
        .baseUrl(apiUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val instance = retrofit.create(HistoricalFigures::class.java)
}