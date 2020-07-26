package com.kiwicorp.sleeptracker.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kiwicorp.sleeptracker.data.source.PickUpRepository
import com.kiwicorp.sleeptracker.data.source.local.PickUpDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ApplicationModule {
    @JvmStatic
    @Singleton
    @Provides
    fun providePickUpRepository(pickUpDatabase: PickUpDatabase): PickUpRepository {
        return PickUpRepository(pickUpDatabase.pickUpDao())
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideDataBase(context: Context): PickUpDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            PickUpDatabase::class.java,
            "Pickup.db").build()
    }
}