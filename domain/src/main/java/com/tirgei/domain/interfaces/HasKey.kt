package com.tirgei.domain.interfaces

/**
 * Indicates Enum class is generated from [String] key to given states
 */
interface HasKey {
    fun fromKey(key: String?): HasKey
    fun toKey(): String
}