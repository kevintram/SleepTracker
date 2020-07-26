package com.kiwicorp.sleeptracker.receiver

import android.content.Context
import android.content.Intent
import android.os.PowerManager
import android.util.Log
import com.kiwicorp.sleeptracker.data.PickUp
import com.kiwicorp.sleeptracker.data.source.PickUpRepository
import dagger.android.DaggerBroadcastReceiver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class PickUpBroadcastReceiver: DaggerBroadcastReceiver() {

    @Inject
    lateinit var pickUpRepository: PickUpRepository

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        if (intent.action == "android.intent.action.SCREEN_ON") {
            val powerManager: PowerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
            if (powerManager.isInteractive) { // if screen is on
                GlobalScope.launch {
                    pickUpRepository.insertPickUp(PickUp())
                }
            }
        } else if (intent.action == "android.intent.action.SCREEN_OFF") {
            GlobalScope.launch {
                pickUpRepository.insertPickUp(PickUp(isPickUp = false))
            }
        }

    }
}