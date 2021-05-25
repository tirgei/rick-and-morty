package com.tirgei.rickandmorty.fakes

import com.tirgei.domain.Result
import com.tirgei.domain.enums.CharacterGender
import com.tirgei.domain.enums.CharacterStatus
import com.tirgei.domain.models.Character
import com.tirgei.domain.models.Location
import com.tirgei.domain.repositories.ICharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeCharactersRepository : ICharactersRepository {

    private var shouldReturnNetworkError = false

    private val characters = listOf(
        Character(
            id = 1,
            name = "Rick Mortez",
            status = CharacterStatus.ALIVE,
            species = "Human",
            type = "Humanoid",
            gender = CharacterGender.MALE,
            origin = Location(1, "Earth", "Planet", "Earth", ""),
            location = Location(1, "Earth", "Planet", "Earth", ""),
            image = "image",
            url = "url",
            episodes = listOf("EP1", "EP2")
        )
    )

    /**
     * Set whether repository should return error response
     * @param value - State of response if error
     */
    fun shouldReturnError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    override suspend fun getCharacters(): Flow<Result<List<Character>>> {
        return if (shouldReturnNetworkError) {
            flowOf(Result.Error("Unable to fetch characters"))
        } else {
            flowOf(Result.Success(characters))
        }
    }

    override suspend fun getCharacter(characterId: Int): Flow<Result<Character>> {
        val errorMessage = "Unable to fetch character"
        return if (shouldReturnNetworkError) {
            flowOf(Result.Error(errorMessage))
        } else {
            val character = characters.firstOrNull { it.id == characterId }
            if (character == null) {
                flowOf(Result.Error(errorMessage))
            } else {
                flowOf(Result.Success(character))
            }
        }
    }


}