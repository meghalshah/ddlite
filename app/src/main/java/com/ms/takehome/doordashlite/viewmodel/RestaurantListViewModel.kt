package com.ms.takehome.doordashlite.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.ms.takehome.doordashlite.models.Restaurant
import com.ms.takehome.doordashlite.repository.RestaurantRepository
import com.ms.takehome.doordashlite.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RestaurantListViewModel @Inject constructor(): ViewModel() {

    val restaurantListViewModel = MutableLiveData<List<Restaurant>>()

    @Inject
    lateinit var restaurantRepository: RestaurantRepository

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)


    constructor(restaurantRepository: RestaurantRepository) : this() {
        this.restaurantRepository = restaurantRepository
    }


    fun fetchRestaurants() {
        scope.launch {
            try {
                val list = restaurantRepository.fetchRestaurantListAsync(Constants.SF_LAT, Constants.SF_LNG)
                restaurantListViewModel.postValue(list)
            } catch (e: Exception) {
              //Handle exception here.
                Log.d(TAG, "Problem getting the restaurant results ${e}")
            }
        }
    }

    companion object {
        const val TAG = "RestaurantListViewModel"
    }
}