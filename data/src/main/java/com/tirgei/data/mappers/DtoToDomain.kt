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
        gender = CharacterGender.valueOf(this.gender),
        status = CharacterStatus.valueOf(this.status),
        species = this.species,
        type = this.type,
        origin = this.origin.toDomain(),
        location = this.location.toDomain(),
        image = this.image,
        url = this.url
    )
}

internal fun LocationResponse.toDomain(): Location {
    return Location(
        id = this.id,
        name = this.name,
        dimension = this.dimension,
        type = this.type,
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
