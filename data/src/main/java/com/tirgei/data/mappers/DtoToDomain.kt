package com.tirgei.data.mappers

import com.tirgei.data.remote.responses.CharacterResponse
import com.tirgei.data.remote.responses.EpisodeResponse
import com.tirgei.data.remote.responses.LocationResponse
import com.tirgei.domain.enums.CharacterGender
import com.tirgei.domain.enums.CharacterStatus
import com.tirgei.domain.models.Character
import com.tirgei.domain.models.Episode
import com.tirgei.domain.models.Location

internal fun CharacterResponse.toDomain(): Character {
    return Character(
        id = this.id,
        name = this.name,
        gender = CharacterGender.UNKNOWN.fromKey(this.gender),
        status = CharacterStatus.UNKNOWN.fromKey(this.status),
        species = this.species,
        type = this.type,
        origin = this.origin.toDomain(),
        location = this.location.toDomain(),
        image = this.image,
        url = this.url,
        episodes = this.episodes
    )
}

internal fun LocationResponse.toDomain(): Location {
    return Location(
        id = this.id ?: 0,
        name = this.name,
        dimension = this.dimension.orEmpty(),
        type = this.type.orEmpty(),
        url = this.url
    )
}

internal fun EpisodeResponse.toDomain(): Episode {
    return Episode(
        id = this.id,
        name = this.name,
        airDate = this.airDate,
        episode = this.episode,
        url = this.url,
        characters = this.characters.map { it.toDomain() }
    )
}
