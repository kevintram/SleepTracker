package com.kiwicorp.sleeptracker.di

import android.content.Context
import com.kiwicorp.sleeptracker.SleepTrackerApplication
import com.kiwicorp.sleeptracker.receiver.ReceiverModule
import com.kiwicorp.sleeptracker.ui.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    AndroidSupportInjectionModule::class,
    MainActivityModule::class,
    ReceiverModule::class
])
interface AppComponent : AndroidInjector<SleepTrackerApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
    
}