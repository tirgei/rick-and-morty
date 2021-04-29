package com.tirgei.domain.models

/**
 * Model class for show episodes
 */
data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val url: String,
    val characters: List<Character>
)
