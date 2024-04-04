package com.example.historicalfigures.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.historicalfigures.model.entity.HistoricalFigures

class HistoricalFiguresDiffUtil: DiffUtil.ItemCallback<HistoricalFigures>() {
    override fun areItemsTheSame(oldItem: HistoricalFigures, newItem: HistoricalFigures): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: HistoricalFigures, newItem: HistoricalFigures): Boolean {
        return oldItem.name == newItem.name
    }
}