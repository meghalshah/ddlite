package com.ms.takehome.doordashlite.network.service

import com.ms.takehome.doordashlite.models.Restaurant
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantApiService {

    @GET("v2/restaurant/")
    fun getRestaurantListAsync(@Query("lat") latitude: String, @Query("lng") longitude: String): Deferred<Response<List<Restaurant>>>
}