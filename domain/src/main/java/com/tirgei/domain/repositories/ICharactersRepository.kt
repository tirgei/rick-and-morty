package com.tirgei.domain.repositories

import com.tirgei.domain.Result
import com.tirgei.domain.models.Character

interface ICharactersRepository {

    suspend fun getCharacters(): Result<List<Character>>

    suspend fun getCharacter(characterId: Int): Result<Character>

}