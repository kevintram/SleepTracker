package com.kiwicorp.sleeptracker

import android.content.IntentFilter
import com.kiwicorp.sleeptracker.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class SleepTrackerApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(applicationContext)
    }
}