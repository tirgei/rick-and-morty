package com.tirgei.domain.usecases

import com.tirgei.domain.Result
import com.tirgei.domain.models.Character
import com.tirgei.domain.repositories.ICharactersRepository
import kotlinx.coroutines.flow.Flow

class GetCharacterUseCase(private val repository: ICharactersRepository) : BaseUseCase<Int, Flow<Result<Character>>> {
    override suspend fun invoke(params: Int?): Flow<Result<Character>> {
        return repository.getCharacter(params ?: 0)
    }
}