package com.ms.takehome.doordashlite.injections.module.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ms.takehome.doordashlite.viewmodel.RestaurantListViewModel
import com.ms.takehome.doordashlite.viewmodel.ViewModelFactory
import com.ms.takehome.doordashlite.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

//@Module
//abstract class ViewModelModule {
//
//    @Binds
//    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(RestaurantListViewModel::class)
//    abstract fun restaurantListViewModel(viewModel: RestaurantListViewModel): ViewModel
//}


@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RestaurantListViewModel::class)
    abstract fun listingsViewModel(viewModel: RestaurantListViewModel): ViewModel

}