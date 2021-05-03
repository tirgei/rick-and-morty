package com.tirgei.domain.usecases

import com.tirgei.domain.Result
import com.tirgei.domain.models.Character
import com.tirgei.domain.repositories.ICharactersRepository

class GetCharacterUseCase(private val repository: ICharactersRepository) : BaseUseCase<Int, Result<Character>> {
    override suspend fun invoke(params: Int?): Result<Character> {
        return repository.getCharacter(params ?: 0)
    }
}