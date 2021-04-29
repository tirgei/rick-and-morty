package com.tirgei.domain.enums

import com.tirgei.domain.interfaces.HasKey

/**
 * Enum class for [Character] gender
 */
enum class CharacterGender : HasKey {
    MALE,
    FEMALE,
    GENDERLESS,
    UNKNOWN;

    override fun fromKey(key: String?): HasKey {
        return when (key) {
            "Male" -> MALE
            "Female" -> FEMALE
            "Genderless" -> GENDERLESS
            else -> UNKNOWN
        }
    }

    override fun toKey(): String {
        return when (this) {
            MALE -> "Male"
            FEMALE -> "Female"
            GENDERLESS -> "Genderless"
            UNKNOWN -> "Unknown"
        }
    }
}