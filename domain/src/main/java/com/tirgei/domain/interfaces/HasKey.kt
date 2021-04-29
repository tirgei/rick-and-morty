package com.tirgei.domain.interfaces

/**
 * Indicates Enum class is generated from [String] key to given states
 */
interface HasKey<out T> {
    fun fromKey(key: String?): T
    fun toKey(): String
}