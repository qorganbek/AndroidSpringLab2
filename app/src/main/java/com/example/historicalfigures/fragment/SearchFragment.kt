package com.example.historicalfigures.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.historicalfigures.model.network.ApiClient
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.historicalfigures.R
import com.example.historicalfigures.databinding.FragmentSearchBinding
import com.example.historicalfigures.model.entity.HistoricalFigures
import com.example.historicalfigures.utils.MAIN
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        binding.mainSearch.setOnClickListener{
            if(binding.mainInput.text.isEmpty()){
                Toast.makeText(requireContext(), "Please enter something", Toast.LENGTH_SHORT).show()
            } else {
                ApiClient.instance.fetchHistoricalFigures(binding.mainInput.text.toString()).enqueue(object : Callback<List<HistoricalFigures>> {
                    override fun onResponse(
                        call: Call<List<HistoricalFigures>>,
                        response: Response<List<HistoricalFigures>>
                    ) {
                        response.body()?.let {
                            println("HistoricalFigureAPI $it")
                            viewModel.updateData(it)
                        }
                    }

                    override fun onFailure(call: Call<List<HistoricalFigures>>, t: Throwable) {
                        TODO("Not yet implemented")
                    }
                })
                MAIN.navController.navigate(R.id.action_searchFragment_to_historicalFiguresListFragment)
            }
        }
    }



}

