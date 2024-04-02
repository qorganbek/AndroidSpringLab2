package com.example.historicalfigures.model.service

import com.example.historicalfigures.model.entity.HistoricalFigures
import retrofit2.http.GET
import retrofit2.Call

interface HistoricalFiguresService {
    @GET
    fun fetchHistoricalFigures(): Call<List<HistoricalFigures>>
}