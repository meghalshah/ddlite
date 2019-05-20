package com.ms.takehome.doordashlite.models

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import com.ms.takehome.doordashlite.BaseTest
import com.ms.takehome.doordashlite.injections.module.component.DaggerAppComponent
import com.ms.takehome.doordashlite.injections.module.component.DaggerTestAppComponent
import com.ms.takehome.doordashlite.network.service.RestaurantApiService
import com.ms.takehome.doordashlite.repository.RestaurantRepository
import com.ms.takehome.doordashlite.ui.activity.MainActivity
import com.ms.takehome.doordashlite.utils.Constants
import com.ms.takehome.doordashlite.viewmodel.RestaurantListViewModel
import dagger.android.DaggerActivity
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.util.inject.Injector
import java.lang.Exception
import javax.inject.Inject

@RunWith(JUnit4::class)
class MainViewModelTest : BaseTest() {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var viewModel: RestaurantListViewModel

    @Mock
    lateinit var mockRepository: RestaurantRepository


    @Before
    override fun setUp() {
        super.setUp()
        MockitoAnnotations.initMocks(this)
        DaggerTestAppComponent.builder().build().inject(this)
        viewModel = RestaurantListViewModel(mockRepository)

    }

    @Test
    fun fetchRestaurants_positiveResponse() {
        runBlocking {
            Mockito.`when`(viewModel.restaurantRepository.fetchRestaurantListAsync(Constants.SF_LAT, Constants.SF_LNG)).thenAnswer {
                return@thenAnswer (ArgumentMatchers.anyList<Restaurant>())
            }

            val observer = mock(Observer::class.java) as Observer<List<Restaurant>>
            viewModel.restaurantListViewModel.observeForever(observer)
            viewModel.fetchRestaurants()

            assertNotNull(viewModel.restaurantListViewModel.value)
            assertEquals(0, viewModel.restaurantListViewModel.value?.size)

        }
    }


    @Test
    fun fetchRestaurants_failureResponse() {
        runBlocking {
            Mockito.`when`(viewModel.restaurantRepository.fetchRestaurantListAsync(Constants.SF_LAT, Constants.SF_LNG)).thenAnswer {
                return@thenAnswer Exception()
            }

            val observer = mock(Observer::class.java) as Observer<List<Restaurant>>
            viewModel.restaurantListViewModel.observeForever(observer)
            viewModel.fetchRestaurants()

            assertNotNull(viewModel.restaurantListViewModel.value)
            assertEquals(null, viewModel.restaurantListViewModel.value)

        }
    }
}