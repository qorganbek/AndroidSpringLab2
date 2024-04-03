package com.example.historicalfigures.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.historicalfigures.databinding.ItemFiguresBinding
import com.example.historicalfigures.fragment.HistoricalFiguresListFragment
import com.example.historicalfigures.model.entity.HistoricalFigures

class HistoricalFiguresListAdapter : ListAdapter<HistoricalFigures, HistoricalFiguresListAdapter.ViewHolder>(HistoricalFiguresDiffUtil())  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFiguresBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemFiguresBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(figure: HistoricalFigures){
            with(binding){
                name.text = figure.name
                title.text = figure.title
            }
        }
    }

}