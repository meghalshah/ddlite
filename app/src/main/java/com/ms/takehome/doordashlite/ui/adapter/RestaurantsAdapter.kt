package com.ms.takehome.doordashlite.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ms.takehome.doordashlite.R
import com.ms.takehome.doordashlite.models.Restaurant
import com.ms.takehome.doordashlite.ui.viewholders.RestaurantVH

class RestaurantsAdapter : RecyclerView.Adapter<RestaurantVH>() {

    private val restaurantList : MutableList<Restaurant> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RestaurantVH {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item_view, parent, false)

        return RestaurantVH(itemView)
    }

    override fun onBindViewHolder(holder: RestaurantVH, position: Int) {
        holder.bind(restaurantList[position])
    }

    override fun onViewRecycled(holder: RestaurantVH) {
        holder.onViewRecycled()
    }

    override fun getItemCount() : Int = restaurantList.size

    fun addItems(restaurant: List<Restaurant>) {
        restaurantList.addAll(restaurant)
        this.notifyDataSetChanged()
    }
}