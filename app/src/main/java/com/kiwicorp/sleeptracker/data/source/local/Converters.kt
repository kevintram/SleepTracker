package com.kiwicorp.sleeptracker.data.source.local

import androidx.room.TypeConverter
import java.time.LocalDateTime

class Converters {
    @TypeConverter
    fun localDateTimeToText(localDateTime: LocalDateTime): String = localDateTime.toString()

    @TypeConverter
    fun textToLocalDateTime(text: String): LocalDateTime = LocalDateTime.parse(text)
}