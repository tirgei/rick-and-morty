package com.tirgei.rickandmorty.di

import com.tirgei.data.repositories.CharactersRepository
import com.tirgei.domain.repositories.ICharactersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBindingModule {

    @Binds
    abstract fun bindCharactersRepository(
        charactersRepository: CharactersRepository
    ): ICharactersRepository

}