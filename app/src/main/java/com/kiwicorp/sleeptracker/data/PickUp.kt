package com.kiwicorp.sleeptracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Entity(tableName = "pickups")
data class PickUp(
    @ColumnInfo(name = "date")
    var date: LocalDateTime = LocalDateTime.now(),

    @ColumnInfo(name = "isPickUp")
    var isPickUp: Boolean = true,

    @PrimaryKey @ColumnInfo(name = "id")
    var id: String = UUID.randomUUID().toString()
) {
    val dateText: String
        get() = DateTimeFormatter.ofPattern("EEE, d MMM, h:mm a").format(date)
}