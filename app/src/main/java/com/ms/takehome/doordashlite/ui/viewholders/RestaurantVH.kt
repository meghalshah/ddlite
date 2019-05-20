package com.ms.takehome.doordashlite.ui.viewholders

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.ms.takehome.doordashlite.models.Restaurant
import com.ms.takehome.doordashlite.utils.Constants
import kotlinx.android.synthetic.main.restaurant_item_view.view.*

class RestaurantVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var requestOptions = RequestOptions()
//            .placeholder(R.drawable.default_placeholder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)

    val name = itemView.restaurant_name
    val speciality = itemView.restaurant_speciality
    val waitTime = itemView.restaurant_wait_time
    val restarauntImage = itemView.restaurant_image_view

    fun bind(restaurant: Restaurant) {
        name.text = restaurant.business.name
        speciality.text = restaurant.description
        waitTime.text = if (restaurant.status_type.equals(Constants.OPEN, true)) restaurant.status else ""

//        Log.d("VH", restaurant.status)


        if (restaurant.cover_img_url.isNullOrEmpty()) {
            clearImage()
        } else {
            Glide.with(itemView.context)
                    .load(restaurant.cover_img_url)
                    .apply(requestOptions)
                    .into(restarauntImage)
        }
    }

    fun onViewRecycled() {
        clearImage()
    }

    private fun clearImage() {
        Glide.with(itemView.context).clear(restarauntImage)
    }
}