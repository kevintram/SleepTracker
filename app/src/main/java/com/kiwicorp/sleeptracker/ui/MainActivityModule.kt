package com.kiwicorp.sleeptracker.ui

import androidx.lifecycle.ViewModel
import com.kiwicorp.sleeptracker.di.ViewModelKey
import com.kiwicorp.sleeptracker.di.ViewModelModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    internal abstract fun mainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel
}