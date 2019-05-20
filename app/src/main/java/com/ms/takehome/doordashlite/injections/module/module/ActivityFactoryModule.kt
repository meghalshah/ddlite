package com.ms.takehome.doordashlite.injections.module.module

import com.ms.takehome.doordashlite.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityFactoryModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity
}