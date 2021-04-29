package com.tirgei.domain.models

import com.tirgei.domain.enums.CharacterGender
import com.tirgei.domain.enums.CharacterStatus

/**
 * Model class for character
 */
data class Character(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val species: String,
    val type: String,
    val gender: CharacterGender,
    val origin: Location,
    val location: Location,
    val image: String,
    val url: String
)
