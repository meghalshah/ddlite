package com.ms.takehome.doordashlite.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.ms.takehome.doordashlite.R
import com.ms.takehome.doordashlite.ui.adapter.RestaurantsAdapter
import com.ms.takehome.doordashlite.viewmodel.RestaurantListViewModel
import com.ms.takehome.doordashlite.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var recyclerView: RecyclerView

    lateinit var restaurantsAdapter: RestaurantsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.restaurants_recycler_view)
        restaurantsAdapter = RestaurantsAdapter()

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = restaurantsAdapter
        }

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(RestaurantListViewModel::class.java)

        viewModel.restaurantListViewModel.observe(this, Observer { restaurantList ->
            Log.d("Hello", "response ${restaurantList?.size}")
            restaurantList?.let {
                restaurantsAdapter.addItems(it)
            }
        })

        viewModel.fetchRestaurants()

    }
}