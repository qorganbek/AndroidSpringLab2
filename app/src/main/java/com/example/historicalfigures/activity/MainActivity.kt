package com.example.historicalfigures.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.historicalfigures.R
import com.example.historicalfigures.databinding.ActivityMainBinding
import com.example.historicalfigures.fragment.HistoricalFiguresListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, HistoricalFiguresListFragment.newInstance())
            .commit()
    }
}