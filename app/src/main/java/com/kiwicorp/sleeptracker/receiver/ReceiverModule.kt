package com.kiwicorp.sleeptracker.receiver

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ReceiverModule {
    @ContributesAndroidInjector
    internal abstract fun pickUpBroadcastReceiver(): PickUpBroadcastReceiver
}