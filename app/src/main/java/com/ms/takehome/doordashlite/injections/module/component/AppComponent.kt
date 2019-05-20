package com.ms.takehome.doordashlite.injections.module.component

import com.ms.takehome.doordashlite.App
import com.ms.takehome.doordashlite.injections.module.module.ActivityFactoryModule
import com.ms.takehome.doordashlite.injections.module.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActivityFactoryModule::class])
internal interface AppComponent :AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}

