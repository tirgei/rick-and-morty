package com.tirgei.rickandmorty.di

import com.tirgei.domain.repositories.ICharactersRepository
import com.tirgei.domain.usecases.GetCharacterUseCase
import com.tirgei.domain.usecases.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun getCharactersUseCase(repository: ICharactersRepository): GetCharactersUseCase {
        return GetCharactersUseCase(repository)
    }

    @Provides
    @Singleton
    fun getCharacterUseCase(repository: ICharactersRepository): GetCharacterUseCase {
        return GetCharacterUseCase(repository)
    }

}