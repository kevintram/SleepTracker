package com.kiwicorp.sleeptracker.data.source

import androidx.lifecycle.LiveData
import com.kiwicorp.sleeptracker.data.PickUp
import com.kiwicorp.sleeptracker.data.source.local.PickUpDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PickUpRepository @Inject constructor(
    private val pickUpDao: PickUpDao
) {
    val pickups: LiveData<List<PickUp>> = pickUpDao.observePickups()

    suspend fun insertPickUp(pickUp: PickUp) {
        withContext(Dispatchers.IO) {
            pickUpDao.insertPickUp(pickUp)
        }
    }

    suspend fun deletePickUps() {
        withContext(Dispatchers.IO) {
            pickUpDao.deletePickUps()
        }
    }
}