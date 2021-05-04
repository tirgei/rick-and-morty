package com.tirgei.data.repositories

import com.tirgei.data.cache.dao.CharactersDao
import com.tirgei.data.mappers.toDomain
import com.tirgei.data.mappers.toEntity
import com.tirgei.data.remote.ApiService
import com.tirgei.domain.Result
import com.tirgei.domain.models.Character
import com.tirgei.domain.repositories.ICharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ExperimentalCoroutinesApi
class CharactersRepository @Inject constructor(
    private val apiService: ApiService, private val dao: CharactersDao): ICharactersRepository {

    override suspend fun getCharacters(): Flow<Result<List<Character>>> = callbackFlow {
        withContext(Dispatchers.IO) {
            dao.getAll().collect {
                offer(Result.Success(it.toDomain()))
            }

            try {
                val characters = apiService.getCharacters()
                dao.insertAll(characters.results.toEntity())
            } catch (e: Exception) {
                offer(Result.Error(e.localizedMessage ?: "Error fetching characters"))
            }
        }

        awaitClose()
    }

    override suspend fun getCharacter(characterId: Int): Flow<Result<Character>> = callbackFlow {
        withContext(Dispatchers.IO) {
            dao.getCharacter(characterId).collect {
                offer(Result.Success(it.toDomain()))
            }

            try {
                val character = apiService.getCharacter(characterId)
                dao.saveCharacter(character.toEntity())
            } catch (e: Exception) {
                offer(Result.Error(e.localizedMessage ?: "Error fetching character"))
            }
        }

        awaitClose()
    }


}