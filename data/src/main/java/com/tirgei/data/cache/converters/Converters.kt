package com.tirgei.data.cache.converters

import android.util.Log
import androidx.room.TypeConverter
import com.tirgei.domain.enums.CharacterGender
import com.tirgei.domain.enums.CharacterStatus

/**
 * DAO converters
 */
class Converters {

    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return value.joinToString(", ")
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        return value.split(", ")
    }

}