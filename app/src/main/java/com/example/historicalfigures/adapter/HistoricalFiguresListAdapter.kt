package com.example.historicalfigures.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.historicalfigures.databinding.ItemFiguresBinding
import com.example.historicalfigures.model.entity.HistoricalFigures
import androidx.recyclerview.widget.ListAdapter
class HistoricalFiguresListAdapter : ListAdapter<HistoricalFigures, HistoricalFiguresListAdapter.ViewHolder>(HistoricalFiguresDiffUtil())  {

//    val items: ArrayList<HistoricalFigures> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFiguresBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

//    fun setItems(list: List<HistoricalFigures>) {
//        items.clear()
//        items.addAll(list)
//        notifyDataSetChanged()
//    }

//    override fun getItemCount(): Int {
//        return items.size
//    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(items[position])
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