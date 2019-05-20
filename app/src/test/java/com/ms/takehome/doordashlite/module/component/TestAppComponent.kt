package com.ms.takehome.doordashlite.injections.module.component

import com.ms.takehome.doordashlite.BaseTest
import com.ms.takehome.doordashlite.injections.module.module.ActivityFactoryModule
import com.ms.takehome.doordashlite.injections.module.module.TestAppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestAppModule::class, ActivityFactoryModule::class])
interface TestAppComponent {

    fun inject(baseTest: BaseTest)

}