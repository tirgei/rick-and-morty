package com.tirgei.data.mappers

import com.tirgei.data.cache.entities.CharacterEntity
import com.tirgei.data.cache.entities.LocationEntity
import com.tirgei.domain.models.Character
import com.tirgei.domain.models.Location

internal fun CharacterEntity.toDomain(): Character {
    return Character(
        id = this.id,
        name = this.name,
        gender = this.gender,
        status = this.status,
        species = this.species,
        type = this.type,
        origin = this.origin.toDomain(),
        location = this.location.toDomain(),
        image = this.image,
        url = this.url,
        episodes = this.episodes
    )
}

internal fun List<CharacterEntity>.toDomain(): List<Character> {
    return this.map { it.toDomain() }
}

internal fun LocationEntity.toDomain(): Location {
    return Location(
        id = this.id,
        name = this.name,
        dimension = this.dimension,
        type = this.type,
        url = this.url
    )
}
