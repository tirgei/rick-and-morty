package com.tirgei.data.cache.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    @Embedded(prefix = "origin_location_")
    val origin: LocationEntity,
    @Embedded(prefix = "current_location_")
    val location: LocationEntity,
    val image: String,
    val url: String,
    val episodes: List<String>
)

