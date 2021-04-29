package com.tirgei.rickandmorty.di

import com.tirgei.data.remote.ApiService
import com.tirgei.data.remote.repositories.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCharactersRepository(
        apiService: ApiService
    ) = CharactersRepository(apiService)

}