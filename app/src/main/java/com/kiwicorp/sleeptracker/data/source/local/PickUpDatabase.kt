package com.kiwicorp.sleeptracker.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kiwicorp.sleeptracker.data.PickUp

@Database(entities = [PickUp::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class PickUpDatabase : RoomDatabase() {
    abstract fun pickUpDao(): PickUpDao
}