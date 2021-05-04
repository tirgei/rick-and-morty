package com.tirgei.data.cache.converters

import androidx.room.TypeConverter
import com.tirgei.domain.enums.CharacterGender
import com.tirgei.domain.enums.CharacterStatus

/**
 * DAO converters
 */
class Converters {

    @TypeConverter
    fun fromCharacterStatus(value: CharacterStatus): String {
        return value.toKey()
    }

    @TypeConverter
    fun toCharacterStatus(value: String): CharacterStatus {
        return CharacterStatus.valueOf(value)
    }

    @TypeConverter
    fun fromCharacterGender(value: CharacterGender): String {
        return value.toKey()
    }

    @TypeConverter
    fun toCharacterGender(value: String): CharacterGender {
        return CharacterGender.valueOf(value)
    }

    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return value.joinToString(", ")
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        return value.split(", ")
    }

}