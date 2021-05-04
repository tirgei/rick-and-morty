package com.tirgei.data.cache.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tirgei.domain.enums.CharacterGender
import com.tirgei.domain.enums.CharacterStatus
import com.tirgei.domain.models.Location

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val species: String,
    val type: String,
    val gender: CharacterGender,
    @Embedded(prefix = "origin_location_")
    val origin: LocationEntity,
    @Embedded(prefix = "current_location_")
    val location: LocationEntity,
    val image: String,
    val url: String,
    val episodes: List<String>
)

