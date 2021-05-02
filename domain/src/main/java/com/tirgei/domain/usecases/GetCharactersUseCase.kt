package com.tirgei.domain.usecases

import com.tirgei.domain.Result
import com.tirgei.domain.models.Character
import com.tirgei.domain.repositories.ICharactersRepository

class GetCharactersUseCase(private val repository: ICharactersRepository) : BaseUseCase<Nothing, Result<List<Character>>> {

    override suspend fun invoke(params: Nothing?): Result<List<Character>> {
        return repository.getCharacters()
    }
}