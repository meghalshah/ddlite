package com.ms.takehome.doordashlite

import android.app.Activity
import android.app.Application
import com.ms.takehome.doordashlite.injections.module.component.AppComponent
import com.ms.takehome.doordashlite.injections.module.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().create(this).inject(this)
    }
}