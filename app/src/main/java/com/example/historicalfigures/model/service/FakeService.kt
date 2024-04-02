package com.example.historicalfigures.model.service

import com.example.historicalfigures.model.entity.HistoricalFigures

object FakeService {
    val historicalFiguresList = listOf(
        HistoricalFigures(
            name = "Dima",
            title = "Software Engineer"
        ),
        HistoricalFigures(
            name = "Daniyar",
            title = "Standup Comic"
        ),
        HistoricalFigures(
            name = "Alimzhan",
            title = "Football commentator"
        ),
        HistoricalFigures(
            name = "Nursultan Qurman",
            title = "Podcast"
        ),
    )
}