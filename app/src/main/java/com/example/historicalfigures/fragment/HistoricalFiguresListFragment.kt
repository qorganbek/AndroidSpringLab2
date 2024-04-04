package com.example.historicalfigures.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.historicalfigures.R
import com.example.historicalfigures.adapter.HistoricalFiguresListAdapter
import com.example.historicalfigures.databinding.FragmentFiguresListBinding
import com.example.historicalfigures.utils.MAIN

class HistoricalFiguresListFragment : Fragment() {
    companion object {
        fun newInstance() = HistoricalFiguresListFragment()
    }

    private lateinit var viewModel: SharedViewModel

    private var _binding: FragmentFiguresListBinding? = null
    private val binding
        get() = _binding!!

    val adapter: HistoricalFiguresListAdapter by lazy {
        HistoricalFiguresListAdapter()
    }

    private fun setupUI(){
        with(binding){
            figuresList.adapter = adapter

            staticSearchBtn.setOnClickListener {
                if(staticSearch.text.isNotEmpty()){
                    val query = staticSearch.text.toString().trim()
                    val filteredList = adapter.currentList.filter {
                        item ->
                        item.name.contains(query, ignoreCase = true)
                    }
                    adapter.submitList(filteredList)
                }
            }
        }
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
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        setupUI()
        viewModel.data.observe(viewLifecycleOwner, Observer {
                newData ->
            adapter.submitList(newData)
        })
        binding.backBtn.setOnClickListener {
            MAIN.navController.navigate(R.id.action_historicalFiguresListFragment_to_searchFragment)
        }
    }

}