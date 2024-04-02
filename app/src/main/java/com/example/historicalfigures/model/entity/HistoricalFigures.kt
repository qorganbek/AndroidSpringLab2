package com.example.historicalfigures.model.entity

import com.google.gson.annotations.SerializedName

data class HistoricalFigures (
    val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("title") val title: String,
)
