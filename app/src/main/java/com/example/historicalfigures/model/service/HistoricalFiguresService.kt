package com.example.historicalfigures.model.service

import android.text.Editable
import com.example.historicalfigures.model.entity.HistoricalFigures
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface HistoricalFiguresService {
    @GET("historicalfigures")
    fun fetchHistoricalFigures(@Query("name") name: String): Call<List<HistoricalFigures>>
}