package com.tirgei.data.mappers

import com.tirgei.data.cache.entities.CharacterEntity
import com.tirgei.data.cache.entities.LocationEntity
import com.tirgei.data.remote.responses.CharacterResponse
import com.tirgei.data.remote.responses.LocationResponse
import com.tirgei.domain.enums.CharacterGender
import com.tirgei.domain.enums.CharacterStatus

internal fun CharacterResponse.toEntity(): CharacterEntity {
    return CharacterEntity(
        id = this.id,
        name = this.name,
        gender = CharacterGender.UNKNOWN.fromKey(this.gender),
        status = CharacterStatus.UNKNOWN.fromKey(this.status),
        species = this.species,
        type = this.type,
        origin = this.origin.toEntity(),
        location = this.location.toEntity(),
        image = this.image,
        url = this.url,
        episodes = this.episodes
    )
}

internal fun List<CharacterResponse>.toEntity(): List<CharacterEntity> {
    return this.map { it.toEntity() }
}

internal fun LocationResponse.toEntity(): LocationEntity {
    return LocationEntity(
        id = this.id ?: 0,
        name = this.name,
        dimension = this.dimension.orEmpty(),
        type = this.type.orEmpty(),
        url = this.url
    )
}
