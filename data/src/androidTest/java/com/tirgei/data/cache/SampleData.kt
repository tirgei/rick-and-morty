package com.tirgei.data.cache

import com.tirgei.data.cache.entities.CharacterEntity
import com.tirgei.data.cache.entities.LocationEntity

internal object SampleData {

    val location1 = LocationEntity(
        1,
        "Earth",
        "Planet",
        "C137",
        "url"
    )

    val character1 = CharacterEntity(
        1,
        "Pickle Rick",
        "Alive",
        "Human",
        "Humanoid",
        "Male",
        location1,
        location1,
        "url",
        "url",
        listOf("episode 1", "episode 2")
    )

    val character2 = CharacterEntity(
        2,
        "Morty",
        "Alive",
        "Human",
        "Humanoid",
        "Male",
        location1,
        location1,
        "url",
        "url",
        listOf("episode 1", "episode 2")
    )

}