package com.tirgei.rickandmorty.di

import com.tirgei.data.remote.repositories.CharactersRepository
import com.tirgei.domain.usecases.GetCharacterUseCase
import com.tirgei.domain.usecases.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    @Singleton
    fun getCharactersUseCase(repository: CharactersRepository): GetCharactersUseCase {
        return GetCharactersUseCase(repository)
    }

    @Provides
    @Singleton
    fun getCharacterUseCase(repository: CharactersRepository): GetCharacterUseCase {
        return GetCharacterUseCase(repository)
    }

}