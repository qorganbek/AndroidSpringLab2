package com.example.historicalfigures.model.entity

import com.google.gson.annotations.SerializedName

data class HistoricalFigures (
    @SerializedName("name") val name: String,
    @SerializedName("title") val title: String,
)
