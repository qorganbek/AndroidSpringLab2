package com.example.historicalfigures.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.historicalfigures.adapter.HistoricalFiguresListAdapter
import com.example.historicalfigures.databinding.FragmentFiguresListBinding
import com.example.historicalfigures.model.service.FakeService

class HistoricalFiguresListFragment : Fragment() {
    companion object {
        fun newInstance() = HistoricalFiguresListFragment()
    }

    private var _binding: FragmentFiguresListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter: HistoricalFiguresListAdapter by lazy {
        HistoricalFiguresListAdapter()
    }

    private fun setupUI(){

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFiguresListBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        adapter.setItems(FakeService.historicalFiguresList)

    }

}