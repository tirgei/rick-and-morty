package com.tirgei.domain.repositories

import com.tirgei.domain.Result
import com.tirgei.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface ICharactersRepository {

    suspend fun getCharacters(): Flow<Result<List<Character>>>

    suspend fun getCharacter(characterId: Int): Flow<Result<Character>>

}