package com.tirgei.domain.enums

import com.tirgei.domain.interfaces.HasKey

/**
 * Enum class to indicate status of the [Character]
 */
enum class CharacterStatus : HasKey<CharacterStatus> {
    DEAD,
    ALIVE,
    UNKNOWN;

    override fun fromKey(key: String?): CharacterStatus {
        return when(key) {
            "Alive" -> ALIVE
            "Dead" -> DEAD
            else -> UNKNOWN
        }
    }

    override fun toKey(): String {
        return when (this) {
            ALIVE -> "Alive"
            DEAD -> "Dead"
            else -> "Unknown"
        }
    }
}