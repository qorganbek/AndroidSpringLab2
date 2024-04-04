package com.example.historicalfigures.model.service

import com.example.historicalfigures.model.entity.HistoricalFigures
import java.util.UUID

object FakeService {
    val historicalFiguresList = listOf(
        HistoricalFigures(
//            id = UUID.randomUUID().toString(),
            name = "Dima",
            title = "Software Engineer"
        ),
        HistoricalFigures(
//            id = UUID.randomUUID().toString(),
            name = "Daniyar",
            title = "Standup Comic"
        ),
        HistoricalFigures(
//            id = UUID.randomUUID().toString(),
            name = "Alimzhan",
            title = "Football commentator"
        ),
        HistoricalFigures(
//            id = UUID.randomUUID().toString(),
            name = "Nursultan Qurman",
            title = "Podcast"
        ),
    )
}