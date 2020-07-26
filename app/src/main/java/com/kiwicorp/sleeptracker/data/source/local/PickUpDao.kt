package com.kiwicorp.sleeptracker.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kiwicorp.sleeptracker.data.PickUp

@Dao
interface PickUpDao {
    /**
     * Observes list of pick ups ordered by their date
     *
     * @return all pick ups
     */
    @Query("SELECT * FROM pickups ORDER BY date")
    fun observePickups(): LiveData<List<PickUp>>


    /**
     * Insert a pick up into the database.
     *
     * @param pickUp the pickup to be inserted
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPickUp(pickUp: PickUp)

    /**
     * Delete all pick ups
     */
    @Query("DELETE FROM pickups")
    suspend fun deletePickUps()
}