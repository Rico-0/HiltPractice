package com.jhhong.hiltpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.jhhong.hiltpractice.adapter.PlaceAdapter
import com.jhhong.hiltpractice.data.Place
import com.jhhong.hiltpractice.databinding.ActivityMainBinding
import com.jhhong.hiltpractice.util.VerticalItemDecorator
import com.jhhong.hiltpractice.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var placeAdapter : PlaceAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initRecyclerView()
        observeData()
    }

    private fun initRecyclerView() {
        placeAdapter = PlaceAdapter()
        binding.placesListView.apply {
            addItemDecoration(VerticalItemDecorator(20))
            adapter = placeAdapter
        }
    }

    private fun observeData() {
        viewModel.getData().observe(this) { data ->
            data?.let {
                val placesData = data.places
                placeAdapter.places = placesData as MutableList<Place>
                placeAdapter.notifyDataSetChanged()
            }
        }
    }
}