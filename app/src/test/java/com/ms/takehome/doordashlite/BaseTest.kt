package com.ms.takehome.doordashlite

import com.ms.takehome.doordashlite.injections.module.component.DaggerTestAppComponent
import com.ms.takehome.doordashlite.injections.module.component.TestAppComponent
import com.ms.takehome.doordashlite.network.service.RestaurantApiService
import com.ms.takehome.doordashlite.repository.RestaurantRepository
import com.ms.takehome.doordashlite.viewmodel.ViewModelFactory
import org.junit.Before
import javax.inject.Inject

abstract class BaseTest {
    lateinit var testAppComponent: TestAppComponent

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

//    @Inject
//    lateinit var repository: RestaurantRepository
//
//    @Inject
//    lateinit var apiService: RestaurantApiService

    @Before
    open fun setUp() {
        testAppComponent = DaggerTestAppComponent.builder().build()
        testAppComponent.inject(this)

        var i = 0;
        i++
    }
}