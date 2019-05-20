package com.ms.takehome.doordashlite.repository

import com.ms.takehome.doordashlite.models.Restaurant
import com.ms.takehome.doordashlite.network.service.RestaurantApiService
import com.ms.takehome.doordashlite.utils.Constants
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class RestaurantRepository @Inject constructor(){

    @Inject
    lateinit var restaurantApiService: RestaurantApiService

    constructor(restaurantApiService: RestaurantApiService) : this() {
        this.restaurantApiService = restaurantApiService
    }

    suspend fun fetchRestaurantListAsync(latitude: String, longitude: String): List<Restaurant>? = coroutineScope {
        val response = restaurantApiService.getRestaurantListAsync(latitude, longitude).await()

        if (response.isSuccessful) {
            return@coroutineScope response.body()
        } else {
            response.errorBody()
            throw Exception()
        }
    }
}