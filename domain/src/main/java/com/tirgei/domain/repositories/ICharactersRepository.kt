package com.tirgei.domain.repositories

import com.tirgei.domain.Result
import com.tirgei.domain.models.Character

interface ICharactersRepository {

    fun getCharacters(): Result<List<Character>>

    fun getCharacter(characterId: Int): Result<Character>

}