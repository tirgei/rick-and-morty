package com.tirgei.data.remote.repositories

import com.tirgei.data.mappers.toDomain
import com.tirgei.data.remote.ApiService
import com.tirgei.domain.Result
import com.tirgei.domain.models.Character
import com.tirgei.domain.repositories.ICharactersRepository
import kotlinx.coroutines.Dispatchers

class CharactersRepository constructor(private val apiService: ApiService): ICharactersRepository {

    override suspend fun getCharacters(): Result<List<Character>> {
        return try {
            with(Dispatchers.IO) {
                val characters = apiService.getCharacters()
                Result.Success(characters.results.map { it.toDomain() })
            }
        } catch (e: Exception) {
            Result.Error(e.localizedMessage)
        }
    }

    override suspend fun getCharacter(characterId: Int): Result<Character> {
        return try {
            with(Dispatchers.IO) {
                val character = apiService.getCharacter(characterId)
                Result.Success(character.toDomain())
            }
        } catch (e: Exception) {
            Result.Error(e.localizedMessage)
        }
    }


}