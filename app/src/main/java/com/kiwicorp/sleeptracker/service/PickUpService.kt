package com.kiwicorp.sleeptracker.service

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import androidx.preference.PreferenceManager
import com.kiwicorp.sleeptracker.receiver.PickUpBroadcastReceiver

class PickUpService : Service() {

    private val pickUpBroadcastReceiver = PickUpBroadcastReceiver()

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.SCREEN_ON")
        intentFilter.addAction("android.intent.action.SCREEN_OFF")

        applicationContext.registerReceiver(pickUpBroadcastReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        applicationContext.unregisterReceiver(pickUpBroadcastReceiver)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }
}