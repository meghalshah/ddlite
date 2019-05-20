package com.ms.takehome.doordashlite.injections.module.module

import android.app.Application
import com.ms.takehome.doordashlite.App
import com.ms.takehome.doordashlite.network.module.RestaurantOkHttpModule
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Module(includes = arrayOf(AndroidInjectionModule::class, ViewModelModule::class, RestaurantOkHttpModule::class))
internal abstract class TestAppModule {

    @Binds
    @Singleton
    internal abstract fun application(app: App): Application
}