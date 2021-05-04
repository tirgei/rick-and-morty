package com.tirgei.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tirgei.data.cache.converters.Converters
import com.tirgei.data.cache.dao.CharactersDao
import com.tirgei.data.cache.entities.CharacterEntity


@Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun charactersDao(): CharactersDao
}