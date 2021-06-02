package com.tirgei.domain.usecases

import com.tirgei.domain.Result
import com.tirgei.domain.models.Character
import com.tirgei.domain.repositories.ICharactersRepository
import kotlinx.coroutines.flow.Flow

class GetCharactersUseCase(private val repository: ICharactersRepository) : BaseUseCase<Nothing, Flow<Result<List<Character>>>> {

    override suspend fun invoke(params: Nothing?): Flow<Result<List<Character>>> {
        return repository.getCharacters()
    }


}