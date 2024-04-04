package com.example.historicalfigures.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.historicalfigures.model.entity.HistoricalFigures

class SharedViewModel : ViewModel() {

    private val _data =  MutableLiveData<List<HistoricalFigures>>()
    val data: LiveData<List<HistoricalFigures>> get() = _data

    fun updateData(newData: List<HistoricalFigures>) {
        _data.value = newData
    }

}