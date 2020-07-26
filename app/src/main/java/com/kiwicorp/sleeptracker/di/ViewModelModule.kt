package com.kiwicorp.sleeptracker.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Module used to define the connection between the framework's [ViewModelProvider.Factory] and
 * our own implementation: [DaggerViewModelFactory].
 */
@Module
@Suppress("UNUSED")
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerViewModelFactory):
            ViewModelProvider.Factory
}